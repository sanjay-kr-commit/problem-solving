class Solution {
    public int balancedStringSplit(String s) {
        int count = 0 ;
        int k = 0 , j = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( j == k && j != 0 ) {
                j = 0 ; k = 0 ;
                count++ ;
            }
            if ( s.charAt(i) == 'L' ) j++ ;
            else if ( s.charAt(i) == 'R' ) k++ ;
        }
        if ( j == k && j != 0 ) count++ ;
        return count ;
    }
}