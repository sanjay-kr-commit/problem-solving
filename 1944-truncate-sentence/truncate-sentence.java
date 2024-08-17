class Solution {
    public String truncateSentence(String s, int k) {
        int index = 0 ;
        while ( index < s.length() && s.charAt(index) == ' ' ) index++ ;
        for ( int wordCount = k , prior = 0 , len = s.length() ; index < len && wordCount > 0 ; index++ ) {
            if ( prior != s.charAt( index ) && s.charAt( index ) == ' ' ) wordCount-- ;
            prior = s.charAt( index ) ;
        }
        if ( index < s.length() ) index-- ;
        return s.substring( 0 , index ) ;
    }
}