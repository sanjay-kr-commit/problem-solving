class Solution {
    public String toLowerCase(String s) {
        StringBuilder lower = new StringBuilder() ;
        int asciiShift = 'a' - 'A' ;
        int start = 'A'-1 ;
        int end = 'Z' + 1 ;
        for ( char c : s.toCharArray() ) {
            lower.append(
                    (char) (c + (( c > start && c < end ) ? asciiShift : 0 ))
            ) ;
        }
        return lower.toString() ;
    }
}