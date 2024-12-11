class Solution {
    public int strStr(String haystack, String needle) {
        haystack += " " ;
        outer:
        for ( int i = 0 , hlen = haystack.length() , nlen = needle.length() , len  = hlen - nlen ; i < len ; i++ ) {
            for ( int j = 0 ; j < nlen ; j++ ) {
                if ( haystack.charAt( i+j ) != needle.charAt( j ) ) continue outer;
            }
            return i;
        }
        return -1 ;
    }
}