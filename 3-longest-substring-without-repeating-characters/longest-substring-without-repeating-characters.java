class Solution {
    public int lengthOfLongestSubstring(String s) {
        char buffer[] = new char[ s.length() ] ;
        HashSet<Character> set = new HashSet<>() ;
        int max = 0 , lp = 0 , rp = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char ch = s.charAt(i);
            if ( !set.contains( ch ) ) {
                set.add( ch ) ;
                buffer[rp++] = ch ;
                if ( max < (rp - lp) ) max = rp-lp ;
            } else {
                while ( set.contains( ch ) &&  lp < rp ) set.remove( buffer[lp++] ) ;
                buffer[rp++] = ch ;
                set.add( ch ) ;
            }
        }
        return max ;
    }
}