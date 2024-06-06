class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] map = new String[26] ;
        int l = 0 , r = 0 , i = 0 , len = s.length() , pLen = pattern.length() ;
        while ( r < len && i < pLen ) {
            while ( r < len && s.charAt( r ) != ' ' ) r++ ;
            String sub = s.substring( l , r ) ;
            int ch = pattern.charAt( i ) - 'a' ;
            if ( map[ch] == null ) {
                for ( String ss : map ) if ( ss != null && ss.equals( sub ) ) return false ;
                map[ch] = sub ;
            } else if ( !map[ch].equals( sub ) ) return false ;
            while ( r < len && s.charAt( r ) == ' ' ) r++ ;
            l = r ;
            i++ ;
        }
        return r == len && i == pLen ;
    }
}