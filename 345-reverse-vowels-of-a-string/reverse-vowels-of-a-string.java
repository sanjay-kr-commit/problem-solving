class Solution {
    public String reverseVowels(String s) {
        char [] str = new char[s.length()];
        for ( int i = 0 , len = s.length() , j = len-1 ; i < len ; i++  ) {
            char c = s.charAt(i);
            if ( !isVowel(c) ) str[i] = c ;
            else {
                while ( j > -1 && !isVowel( s.charAt( j ) ) ) j-- ;
                if ( j < -1 ) break;
                str[i] = s.charAt(j--) ;
            }
        }
        return new String( str ) ;
    }

    boolean isVowel( char c ) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}