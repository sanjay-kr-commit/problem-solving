class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0 , leni = s.length() , lent = t.length();
        while ( i < leni && j < lent ) {
            if ( s.charAt( i ) == t.charAt( j++ ) ) i++ ;
        }
        return i == leni ;
    }
}