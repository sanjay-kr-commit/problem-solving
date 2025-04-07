class WordDictionary {

    static class Node {
        Node [] children = new Node[26];
        boolean word;
    }

    Node root = new Node();

    public void addWord(String word) {
        Node current = root ;
        for ( int i = 0 ; i < word.length() ; i++ ) {
            int index = word.charAt(i) - 'a';
            if ( current.children[index] == null ) current.children[index] = new Node();
            current = current.children[index];
        }
        current.word = true;
    }

    private boolean regexSearch(String pattern, Node current , int index , int len ) {
        if ( index == len ) return current != null && current.word ;
        if ( current == null ) return false;
        boolean result = false ;
        int nextIndex = pattern.charAt( index++ ) - 'a' ;
        if ( nextIndex > -1 ) result = regexSearch( pattern , current.children[nextIndex] , index , len ) ;
        else for ( int i = 0 ; i < 26 ; i++ ) result |= regexSearch( pattern , current.children[i] , index , len ) ;
        return result ;
    }

    public boolean search(String word) {
        return regexSearch( word , root , 0 , word.length() );
    }
}
