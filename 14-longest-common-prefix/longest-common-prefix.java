class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        if (strs.length == 1){
            return strs[0];
        }
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;

    }

    class TrieNode {
        TrieNode [] child = new TrieNode[26];
        int [] childFreq = new int[26] ;
    }
    
    public String longestCommonPrefixWithTrie(String[] strs) {
        if ( strs.length == 0 ) return "" ;
        else if ( strs.length == 1 ) return strs[0] ;
        int minSize = Integer.MAX_VALUE ;
        for ( String str : strs ) minSize = Math.min(minSize, str.length()) ;
        TrieNode root = new TrieNode() ;
        // add 0 - n-2
        for ( int i = 0 ; i < strs.length-1 ; i++ ) {
            TrieNode curr = root;
            for ( int j = 0 ; j < minSize ; j++ ) {
                int index = strs[i].charAt( j )-'a' ;
                if ( curr.child[index] == null ) curr.child[index] = new TrieNode() ;
                curr.childFreq[index]++ ;
                curr = curr.child[index] ;
            }
        }
        // add n-1 and traverse
        int size = 0 ;
        char [] buff = new char[minSize] ;
        TrieNode curr = root;
        for ( int i = 0, lastItem = strs.length-1 ; i < minSize && curr != null ; i++ ) {
            int index = strs[lastItem].charAt(i)-'a' ;
            if ( curr.childFreq[index] != lastItem ) break;
            buff[size++] = strs[lastItem].charAt(i) ;
            curr = curr.child[index] ;
        }
        return new String(buff, 0, size) ;
    }


}