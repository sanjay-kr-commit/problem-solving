class Solution {
    public boolean isSubsequence(String s, String t) {
       int i = 0 , j = 0 ;
       while ( i < s.length() ) {
         char c = s.charAt( i ) ;
         while ( j < t.length() && t.charAt(j) != c ) j++ ;
         if ( j >= t.length() || t.charAt(j) != c ) return false ;          
         i++ ; j++ ;
       }                                                 
       return true ;                     
    }
}
