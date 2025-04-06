class Solution {
    public String minWindow(String s, String t) {
        int [] mapT = new int[128] , map = new int[128];
        for ( int i = 0 ; i < t.length() ; i++ ) mapT[t.charAt(i)]++;
        String min = "" ;
        int l = 0 , r = 0 , len = s.length() ;
        while ( r < len ) {
            map[s.charAt(r++)]++;
            if ( !contains(map,mapT) ) continue;
            while ( l < r ) {
                char c = s.charAt(l++);
                map[c]-- ;
                if ( map[c] < mapT[c] ) {
                    map[s.charAt(--l)]++ ;
                    break;
                }
            }
            if (min.isEmpty() || min.length() > r-l ) min = s.substring(l,r) ;
        }
        return min ;
    }

    boolean contains( int [] map , int [] mapT ) {
        for ( int i = 0 ; i < 128 ; i++ ) {
            if ( map[i] < mapT[i] ) return false ;
        }
        return true ;
    }

}
