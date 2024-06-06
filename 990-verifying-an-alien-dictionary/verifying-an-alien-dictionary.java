class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] orderArr = new int[26];
        for ( int i = 0 ; i < order.length() ;i++ ) orderArr[ order.charAt( i ) - 'a' ] = i ;
        outer:
        for ( int i = 1 ; i < words.length ;i++ ) {
            int common = Math.min(words[i - 1].length(), words[i].length());
            int j = 0 ;
            while ( j < common ) {
                int w1 = orderArr[ words[i-1].charAt( j ) - 'a' ] , w2 = orderArr[ words[i].charAt( j ) - 'a' ] ;
                if ( w1 < w2 ) continue outer;
                else if ( w1 > w2 ) return false ;
                j++ ;
            }
            if ( words[i-1].length() > words[i].length() ) return false ;
        }
        return true ;
    }
}