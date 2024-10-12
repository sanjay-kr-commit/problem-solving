class Solution {
    public int maxVowels(String s, int k) {
        int [] deque = new int[ s.length() ] ;
        int size = 0 , maxVowelCount = 0 , windowVowelCount = 0 , peek = 0 ;
        for ( int i = 0 , len = Math.min( k , s.length() ) ; i < len ; i++ ) {
            if ( isVowel( s.charAt( i ) ) ) {
                windowVowelCount++ ;
                deque[size++] = i ;
            }
        }
        maxVowelCount = windowVowelCount ;
        for ( int i = k , len = s.length() ; i < len ; i++ ) {
            if ( peek < size && i-k == deque[peek] ) {
                peek++ ;
                windowVowelCount-- ;
            }
            if ( isVowel( s.charAt( i ) ) ) {
                windowVowelCount++ ;
                deque[size++] = i ;
            }
            maxVowelCount = Math.max( maxVowelCount , windowVowelCount ) ;
        }
        return maxVowelCount ;
    }

    boolean isVowel( char c ) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ;
    }
}