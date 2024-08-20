import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        int maxSize = 0 ;
        for ( int i = 0 ; i < folder.length ; i++ ) {
            TrieNode node = root;
            char [] buff = new char[ folder[i].length() ];
            int size = 0 ;
            if ( maxSize < folder[i].length() ) maxSize = folder[i].length();
            for ( int j = 0 ; j < folder[i].length() ; j++ ) {
                if ( folder[i].charAt( j ) == '/' && size > 0 ) {
                    String str = new String( buff , 0 , size ) ;
                    if ( !node.nextNode.containsKey( str ) ) node.nextNode.put( str , new TrieNode() ) ;
                    node = node.nextNode.get( str ) ;
                    size = 0 ;
                } else if ( folder[i].charAt( j ) != '/' )buff[size++] = folder[i].charAt(j);
            }
            if ( size > 0 ) {
                String str = new String( buff , 0 , size ) ;
                if ( !node.nextNode.containsKey( str ) ) node.nextNode.put( str , new TrieNode() ) ;
                node = node.nextNode.get( str ) ;
            }
            node.isEnd = true ;
        }
        ArrayList<String> result = new ArrayList<>( folder.length ) ;
        extractString( root , result , new char[ maxSize ] , 0 );
        return result ;
    }

    void extractString( TrieNode node , ArrayList<String> result , char [] buff , int size ) {
        if ( node == null ) return;
        if ( node.isEnd ){
            result.add( new String( buff , 0 , size ) );
            return;
        }
        Iterator hmIterator = node.nextNode.entrySet().iterator();
        while ( hmIterator.hasNext() ) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            int newSize = size ;
            buff[newSize++] = '/' ;
            String str = (String) mapElement.getKey() ;
            for ( int i = 0 ; i < str.length() ; i++ ) buff[newSize++] = str.charAt( i ) ;
            extractString( (TrieNode) mapElement.getValue() , result , buff , newSize ) ;
        }
    }

}
class TrieNode {
    HashMap<String,TrieNode> nextNode = new HashMap<>();
    boolean isEnd = false;
}