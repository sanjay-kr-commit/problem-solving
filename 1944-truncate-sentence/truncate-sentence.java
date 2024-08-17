class Solution {
    public String truncateSentence(String s, int k) {
        int size = s.length() ;
        int count = 0 ;
        for( int i = 0 ; i < size ; i++) {
            if ( s.charAt(i) == ' ' ) count++ ;
            if( count == k ) return s.substring( 0 , i ) ;
        }
        return s;
    }
}