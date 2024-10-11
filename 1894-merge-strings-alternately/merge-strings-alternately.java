class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0 , j = 0 , k = 0 , m = word1.length() , n = word2.length() ;
        char [] mergedString = new char [ m+n ] ;
        while ( j < m && k < n ) mergedString[i++] = ( i % 2 != 0 ) ? word1.charAt( j++ ) : word2.charAt( k++ ) ;
        while ( j < m ) mergedString[i++] = word1.charAt( j++ ) ;
        while ( k < n ) mergedString[i++] = word2.charAt( k++ ) ;
        return new String( mergedString ) ;
    }
}