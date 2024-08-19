class Solution {
    public String mergeAlternately(String word1, String word2) {
        char [] buff = new char[ word1.length() + word2.length() ];
        int i = 0 , j = 0 , k = 0 , len1 = word1.length() , len2 = word2.length() ;
        boolean turn = true ;
        while ( i < len1 && j < len2 ) {
            buff[k++] = ( turn ) ? word1.charAt(i++) : word2.charAt(j++) ;
            turn = !turn ;
        }
        while ( i < len1 ) buff[k++] = word1.charAt(i++) ;
        while ( j < len2 ) buff[k++] = word2.charAt(j++) ;
        return new String( buff ) ;
    }
}