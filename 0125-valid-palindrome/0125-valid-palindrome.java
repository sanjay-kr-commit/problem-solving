public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0 , j = s.length()-1;
        while (i < j) {
            while ( i < j && !isAllowed( s.charAt(i) ) ) i++;
            while ( i < j && !isAllowed( s.charAt(j) ) ) j-- ;
            if ( i < j && !isEqual( s.charAt(i++), s.charAt(j--) ) ) return false;
        }
        return true ;
    }
    
    boolean isNumeric( char c ) {
        return c >= '0' && c <= '9' ;
    }
    
    boolean isAllowed( char c ) {
        return ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) || isNumeric( c ) ;
    }
    
    boolean isEqual( char c1, char c2 ) {
        int diff = c1 - c2;
        return (isNumeric(c1) || isNumeric(c2)) ? diff == 0 : (diff == 0 || diff == 32 || diff == -32);
    }
    
}