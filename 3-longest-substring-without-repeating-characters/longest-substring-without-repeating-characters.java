class Solution {
    public int lengthOfLongestSubstring(String s) {
        char buffer[] = new char[ s.length() ] ;
        boolean set[] = new boolean[ 128 ] ;
        int max = 0 , lp = 0 , rp = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char ch = s.charAt(i);
            if ( !set[ch] ) {
                set[ch] = true ;
                buffer[rp++] = ch ;
                if ( max < (rp - lp) ) max = rp-lp ;
            } else {
                while ( set[ch] &&  lp < rp ) set[ buffer[lp++]] = false ;
                buffer[rp++] = ch ;
                set[ch] = true ;
            }
        }
        return max ;
    }
}