class Solution {

    public boolean isPalindrome(String s) {
        int l = 0 , r = s.length()-1;
        while ( l < r ) {
            while ( l < r && !isAlphaNumeric( s.charAt(l) ) ) l++ ;
            while ( l < r && !isAlphaNumeric( s.charAt(r) ) ) r-- ;
            if ( lowercase( s.charAt(l) ) != lowercase( s.charAt(r) ) ) return false ;
            l++ ;
            r-- ;
        }
        return true ;
    }

    boolean isLowerCaseAlphabet( char c ) {
        return ( c >= 'a' && c <= 'z' ) ;
    }

    boolean isUpperCaseAlphabet( char c ) {
        return ( c >= 'A' && c <= 'Z' ) ;
    }
    
    boolean isNumeric( char c ) {
        return ( c >= '0' && c <= '9' ) ;
    }

    boolean isAlphaNumeric(char c ) {
        return isNumeric( c ) || isLowerCaseAlphabet( c ) || isUpperCaseAlphabet( c ) ;
    }

    char lowercase(char c) {
        return isNumeric( c ) ? c : isLowerCaseAlphabet( c ) ? c : (char) ( c + ( 'a' - 'A' ) );
    }

}