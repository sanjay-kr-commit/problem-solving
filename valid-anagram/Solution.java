import java.util.Arrays;

// 7ms
class Solution1 {
    public boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false ;
        char[]ss = s.toCharArray() ;
        char[]tt = t.toCharArray() ;
        Arrays.sort(ss);
        Arrays.sort(tt);
        for ( int i = 0 ; i < ss.length ; i++ ) {
            if ( ss[i] != tt[i] ) return false ;
        }
        return true ;
    }
}

// 3ms
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false ;
        int[] freq = new int[26] ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            freq[s.charAt(i)-'a']++ ;
            freq[t.charAt(i)-'a']-- ;
        }
        for ( int i = 0 ; i < 26 ; i++ ) {
            if ( freq[i] != 0 ) return false ;
        }
        return true ;
    }
}
