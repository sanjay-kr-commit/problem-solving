class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
//        int[] childFreq = new int[26];
        int freq = 0;
    }

    public int[] sumPrefixScores(String[] words) {
        int [] prefixScore = new int[words.length];
        TrieNode root = new TrieNode();
        for ( String word : words ) insert( root , word , 0 , word.length() );
        for ( int i = 0 ; i < words.length ; i++ ) {
            prefixScore[i] = countPrefixScore( root , words[i] , 0 , words[i].length() ) - root.freq;
        }
        return prefixScore ;
    }

    void insert( TrieNode node , String str , int index , int len ) {
        if ( node == null ) return;
        if ( index == len ) {
            node.freq++ ;
            return;
        }
        int addr = str.charAt( index ) - 'a' ;
        node.freq++ ;
        if ( node.child[addr] == null ) node.child[addr] = new TrieNode();
//        node.childFreq[addr]++ ;
        insert( node.child[addr] , str , index+1 , len );
    }

    int countPrefixScore( TrieNode node , String str , int index , int len ) {
        if ( node == null ) return 0 ;
        if ( index == len ) return node.freq ;
        int addr = str.charAt( index ) - 'a' , count = node.freq ;
        count += countPrefixScore( node.child[addr] , str , index+1 , len );
        return count ;
    }

}