class Solution {
    public int maxVowels(String s, int k) {
        boolean [] isVowels = new boolean[128];
        isVowels['a'] = true ;
        isVowels['e'] = true ;
        isVowels['i'] = true ;
        isVowels['o'] = true ;
        isVowels['u'] = true ;
        isVowels['A'] = true ;
        isVowels['E'] = true ;
        isVowels['I'] = true ;
        isVowels['O'] = true ;
        isVowels['U'] = true ;
        int [] deque = new int[ s.length() ] ;
        int size = 0 , maxVowelCount = 0 , windowVowelCount = 0 , peek = 0 ;
        for ( int i = 0 , len = Math.min( k , s.length() ) ; i < len ; i++ ) {
            if ( isVowels[ s.charAt( i ) ] ) {
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
            if ( isVowels[ s.charAt( i ) ] ) {
                windowVowelCount++ ;
                deque[size++] = i ;
            }
            if ( maxVowelCount < windowVowelCount ) maxVowelCount = windowVowelCount ;
        }
        return maxVowelCount ;
    }

}