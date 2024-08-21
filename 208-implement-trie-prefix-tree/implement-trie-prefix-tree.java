class Trie {

    TrieNode root;

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false ;
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        int index = 0 , len = word.length();
        while ( index < len ) {
            int addr = word.charAt(index++) - 'a';
            if ( current.children[addr] == null ) current.children[addr] = new TrieNode();
            current = current.children[addr];
        }
        current.isWord = true ;
    }

    public boolean search(String word) {
        TrieNode current = root;
        int index = 0 , len = word.length();
        while ( index < len && current != null ) {
            int addr = word.charAt(index++) - 'a';
            current = current.children[addr];
        }
        return index == len && current != null && current.isWord ;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int index = 0 , len = prefix.length();
        while ( index < len && current != null ) {
            int addr = prefix.charAt(index++) - 'a';
            current = current.children[addr];
        }
        return index == len && current != null;
    }
}
