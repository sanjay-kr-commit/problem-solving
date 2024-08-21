class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        int index = 0 , len = word.length();
        while ( index < len ) {
            int addr = word.charAt(index++) - 'a';
            if ( current.children[addr] == null ) current.children[addr] = new TrieNode();
            current = current.children[addr];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return search( root , word , 0 , word.length() ) ;
    }

    private boolean search( TrieNode node , String word , int index, int len ) {
        if ( node == null ) return false ;
        if ( len == index ) return node.isWord ;
        if ( word.charAt( index ) == '.' ) {
            boolean doesMatches = false ;
            for ( int i = 0 ; i < 26 && !doesMatches ; i++ ) doesMatches = search( node.children[i] , word , index+1, len ) ;
            return doesMatches ;
        } else return search( node.children[word.charAt(index)-'a'] , word , index+1, len ) ;
    }

    class TrieNode {
        TrieNode [] children = new TrieNode[26];
        boolean isWord = false;
    }

}