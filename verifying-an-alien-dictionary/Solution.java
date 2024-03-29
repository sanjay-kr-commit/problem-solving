class Solution {

    int[] cached_order = new int[ 26 ] ;

    public boolean isAlienSorted(String[] words, String order) {
        for ( int i = 0 ; i < 26 ; i++ ) cached_order[order.charAt( i )-'a'] = i ;
        outer:
        for ( int i = 1 ; i < words.length ; i++ ) {
            String word1 = words[i-1] ,
                   word2 = words[i] ;
            int word1len = word1.length() ,
                word2len = word2.length() ,
                common = word1len < word2len ? word1len : word2len ,
                j = 0 ;
            while ( j < common ) {
                if ( cached_order[word1.charAt( j )-'a'] < cached_order[word2.charAt( j )-'a'] ) continue outer;
                else if ( cached_order[word1.charAt( j )-'a'] > cached_order[word2.charAt( j )-'a'] ) return false ;
                j++ ;
            }
            if ( word1len > word2len ) return false ;
        }
        return true ;
    }

}
