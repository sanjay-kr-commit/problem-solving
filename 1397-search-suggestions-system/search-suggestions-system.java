import java.util.ArrayList;
import java.util.List;

class Solution {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false ;
        void insert(String word) {
            insert( word , 0 , word.length() );
        }
        private void insert( String word , int index , int len ) {
            if ( index >= len ) {
                isEnd = true ;
                return;
            }
            int childIndex = word.charAt( index ) - 'a' ;
            if ( children[childIndex] == null ) children[childIndex] = new TrieNode();
            children[childIndex].insert( word ,index+1 , len );
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for ( String product : products ) root.insert( product );
        ArrayList<List<String>> autoCompletePrompt = new ArrayList<>();
        TrieNode curr = root ;
        for ( int i = 0 ; i < searchWord.length() ; i++ ) {
            if ( curr == null ) break;
            curr = curr.children[searchWord.charAt(i) - 'a'];
            ArrayList<String> prompts = new ArrayList<>( 3 );
            genPrompts( searchWord.substring( 0 , i+1 )  , curr , prompts );
            autoCompletePrompt.add( prompts ) ;
            if ( prompts.isEmpty() ) break;
        }
        for ( int i = autoCompletePrompt.size() ; i < searchWord.length() ; i++ ) {
            autoCompletePrompt.add( new ArrayList<>() ) ;
        }
        return autoCompletePrompt ;
    }

    private void genPrompts( String st , TrieNode node , ArrayList<String> prompts ) {
        if ( node == null || prompts.size() > 2 ) return;
        if ( node.isEnd ) prompts.add(st);
        if ( prompts.size() > 2 ) return;
        for ( int i = 0 ; i < 26 ; i++ ) {
            genPrompts( st + (( char ) ( i + 'a' )) , node.children[i] , prompts );
        }
    }

}