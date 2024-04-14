class Solution {

    public String longestPalindrome(String s) {
        if ( s.length() < 2 ) return s ;
        int l = 0 , r = 0 , max = 0 ;
        int [] ref = new int [2];
        for ( int i = max , len = s.length() ; i < len ; i++ ) {
            if ( expandAroundCenter( s , i , i , max , ref ) && ref[1]-ref[0]+1 > max ) {
                max = ref[1]-ref[0]+1 ;
                l = ref[0] ;
                r = ref[1]+1 ;
                len = s.length() - max/2 ;
            }
            if ( expandAroundCenter( s , i-1 , i , max , ref ) && ref[1]-ref[0]+1 > max ) {
                max = ref[1]-ref[0]+1 ;
                l = ref[0] ;
                r = ref[1]+1 ;
                len = s.length() - max/2 ;
            }
        }
        return s.substring( l , r ) ;
    }

    boolean expandAroundCenter( String s , int centerL , int centerR , int max , int[] ref ) {
        if ( centerL < 0 || centerR >= s.length() ) return false ;
        int maxExpand = Math.min( centerL , s.length()-centerR ) ;
        if ( maxExpand < max/2 ) return false ;
        while ( centerL > -1 && centerR < s.length() && s.charAt(centerL) == s.charAt(centerR) ) {
            centerL-- ;
            centerR++ ;
        }
        ref[0] = centerL+1 ;
        ref[1] = centerR-1 ;
        return true ;
    }

}