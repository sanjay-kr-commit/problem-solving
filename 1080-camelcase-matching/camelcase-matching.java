class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> checks = new ArrayList<>( queries.length ) ;
        if (pattern.isEmpty() || queries.length < 1 ) return checks ;
        int len = pattern.length() ;
        outer:
        for ( String query : queries ) {
            int i = 0 , j = 0 ,
                len2 = query.length() ;
            while ( i < len && j < len2 ) {
                char chp = pattern.charAt( i ) ;
                char chq = query.charAt( j ) ;
                if ( !isCapital(chp) && isCapital(chq) || (isCapital(chp)&&isCapital(chq)&&chq != chp) ) {
                    checks.add( false ) ;
                    continue outer;
                } if ( chp == chq ) i++ ;
                j++ ;
            }
            if ( i >= len ) while ( j < len2  ) {
                if ( isCapital( query.charAt(j) ) ) {
                    checks.add( false ) ;
                    continue outer;
                }
                j++;
            }
            checks.add( i >= len ) ;
        }
        return checks ;
    }

    boolean isCapital( char c ) {
        return c >= 'A' && c <= 'Z' ;
    }

}