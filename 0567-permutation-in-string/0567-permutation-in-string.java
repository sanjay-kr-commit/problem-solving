class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if ( s1.length() > s2.length() ) return false ;
        int[] map = new int[26];
        for ( char c : s1.toCharArray() )
            map[c - 'a']++;
        int [] slidingMap = new int[26];
        int l = 0, windowLength = s1.length() , r = 0 , len = s2.length() ;
        while ( r < windowLength ) slidingMap[s2.charAt(r++)-'a']++;
        if ( isEqual(map, slidingMap) ) return true ;
        while ( r < len ) {
            slidingMap[s2.charAt(l++)-'a']-- ;
            slidingMap[s2.charAt(r++)-'a']++ ;
            if ( isEqual(map, slidingMap) ) return true ;
        }
        return false ;
    }
    
    boolean isEqual( int [] map1 , int [] map2 ) {
        for ( int i = 0 ; i < 26 ; i++ ) {
            if ( map1[i] != map2[i] ) return false ;
        }
        return true ;
    }
}
