class Solution {

    public String longestPalindrome(String s) {
        if ( s.length() < 2 ) return s ;
        int l = 0 , r = 0 , max = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            for ( int j = i ; j < s.length() ; j++ ) {
                if (isPalindrome( s , i , j ) && max < j-i+1 ) {
                    l = i ;
                    r = j+1 ;
                    max = j-i+1 ;
                }
            }
        }
        return s.substring( l , r ) ;
    }

    boolean isPalindrome(String s , int i , int j) {
        while ( i < j ) {
            if ( s.charAt(i) != s.charAt(j) ) return false ;
            i++ ;
            j-- ;
        }
        return true ;
    }

}