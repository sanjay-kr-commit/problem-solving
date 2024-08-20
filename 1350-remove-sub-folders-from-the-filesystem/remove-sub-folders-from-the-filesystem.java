import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] child = new TrieNode[27];
    boolean isEnd;
}

class Solution {

    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        int maxSize = 0 ;
        for ( String dir : folder ){
            int len = dir.length() ;
            insertString( root , dir , 0 , len );
            maxSize = ( maxSize < len ) ? len : maxSize;
        }
        ArrayList<String> rootFolder = new ArrayList<>();
        traverse( root , rootFolder , new char[ maxSize ] , 0 );
        return rootFolder ;
    }

    void insertString( TrieNode node , String string , int index , int len ) {
        if ( node == null ) return;
        if ( index == len ) {
            node.isEnd = true;
            return;
        }
        int addr = ( string.charAt( index ) == '/' ) ? 26 : string.charAt( index ) - 'a' ;
        if ( node.child[addr] == null ) node.child[addr] = new TrieNode();
        insertString( node.child[addr] , string , index + 1 , len );
    }

    void traverse( TrieNode node , ArrayList<String> rootFolder , char [] buffer , int size) {
        if ( node == null ) return;
        if ( node.isEnd ) {
            rootFolder.add( new String( buffer , 0 , size ) );
        }
        if ( node.child[26] != null && !node.isEnd ) {
            buffer[size] = '/' ;
            traverse( node.child[26] , rootFolder , buffer, size + 1 ) ;
        }
        for ( int i = 0 ; i < 26 ; i++ ) {
            if ( node.child[i] == null ) continue;
            buffer[size] = (char)(i+'a');
            traverse( node.child[i] , rootFolder , buffer, size + 1 ) ;
        }
    }


}