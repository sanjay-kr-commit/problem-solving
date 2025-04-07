class Trie {

    static class Node {
        Node [] children = new Node[26];
        boolean word = false;
    }

    Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for ( int i = 0 ; i < word.length() ; i++ ) {
            int index = word.charAt(i) - 'a';
            if ( current.children[index] == null ) current.children[index] = new Node();
            current = current.children[index];
        }
        current.word = true;
    }

    public boolean search(String word) {
        Node current = root;
        for ( int i = 0 ; i < word.length() ; i++ ) {
            int index = word.charAt(i) - 'a';
            if ( current.children[index] == null ) return false;
            current = current.children[index];
        }
        return current != null && current.word;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for ( int i = 0 ; i < prefix.length() ; i++ ) {
            int index = prefix.charAt(i) - 'a';
            if ( current.children[index] == null ) return false;
            current = current.children[index];
        }
        return current != null ;
    }
}
