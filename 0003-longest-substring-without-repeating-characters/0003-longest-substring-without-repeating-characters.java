import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] map = new int[128] ;
        Arrays.fill(map, -1);
        int max = 0 , l = 0 , r = 0 ;
        while ( r < s.length() ) {
            char ch = s.charAt(r);
            if ( map[ch] > l ) l = map[ch] ;
            map[ch] = ++r ;
            max = Math.max( max , r-l ) ;
        }
        return max ;
    }
}