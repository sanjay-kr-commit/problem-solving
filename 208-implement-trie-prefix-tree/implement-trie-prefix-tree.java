import java.util.ArrayList;

class Trie {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root ;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root ;
        for ( int i = 0 ; i < word.length() ; i++ ) {
            if ( curr.children[word.charAt(i)-'a'] == null ) curr.children[ word.charAt(  i ) - 'a' ] = new TrieNode();
            curr = curr.children[ word.charAt(i) - 'a' ];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root ;
        for ( int i = 0 ; i < word.length() ; i++ ) {
            if ( curr.children[ word.charAt(i) - 'a' ] == null ) return false ;
            curr = curr.children[ word.charAt(i) - 'a' ];
        }
        return curr != null && curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root ;
        for ( int i = 0 ; i < prefix.length() ; i++ ) {
            if ( curr.children[ prefix.charAt(i) - 'a' ] == null ) return false ;
            curr = curr.children[ prefix.charAt(i) - 'a' ];
        }
        return curr != null ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */