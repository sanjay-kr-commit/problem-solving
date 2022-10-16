// 3ms 
class Solution {

    public boolean equal( String s , int i , int j ) {
        return s.charAt(i) == s.charAt(j) ;
    }

    public int index( String s , int index , boolean ascend ) {
        while ( true ) {
            if ( s.charAt(index) >= 'a' && s.charAt(index) <= 'z' ) break ;
            if ( s.charAt(index) >= 'A' && s.charAt(index) <= 'Z' ) break ;
            if ( s.charAt(index) >= '0' && s.charAt(index) <= '9' ) break ;
            if ( ascend ) {
                index++ ;
                if ( index >= s.length() -1 ) break ;
            } else {
                index-- ;
                if ( index < 0 ) break ;
            }
        }
        return index ;
    }

    public boolean isPalindrome(String s) {      
        boolean isPalindrome = true ;
	s = s.toLowerCase() ;
        int i = 0 , j = s.length()-1 , len = j ;
        while ( isPalindrome && i < j ) {
            i = index(s, i, true );
            j = index(s, j, false );
            if ( i > len || j < 0 ) break ;
            isPalindrome = equal(s, i, j) ;
            i++ ; j-- ;
        }
        return isPalindrome ;
    }
}
