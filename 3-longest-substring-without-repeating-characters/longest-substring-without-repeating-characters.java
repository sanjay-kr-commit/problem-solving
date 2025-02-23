class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] map = new int[128];
        int l = 0 , r = 0 , max = 0 ;
        while ( r < s.length() ) {
            char c = s.charAt(r);
            if ( map[c] > l ) l = map[c];
            max = Math.max( max , r-l+1 ) ;
            map[c] = r+1 ;
            r++ ;
        }
        return max ;
    }
}