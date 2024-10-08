class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long postFix = 0 , max1 = 0 , max2 = 0 ;
        for ( int i = text.length() -1 ; i > -1 ; i-- ) {
            if ( text.charAt(i) == pattern.charAt(0) ) {
                max1 += postFix;
                max2 += postFix + 1 ;
            }
            if ( text.charAt(i) == pattern.charAt(1) ) postFix++ ;
        }
        max1 += postFix ;
        return Math.max(max1, max2) ;
    }
}