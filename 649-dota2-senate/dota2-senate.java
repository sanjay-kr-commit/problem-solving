class Solution {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        int [] r = new int[ len ] ,
               d = new int[ len ] ;
        int re = 0 , rd = 0 , de = 0 , dd = 0 ;
        for ( int i = 0 ; i < len ; i++ ) {
            if ( senate.charAt( i ) == 'R' ) r[rd++] = i ;
            else d[dd++] = i ;
        }
        while ( rd-re > 0 && dd-de > 0 ) {
            int i = r[re++] ;
            int j = d[de++] ;
            if ( i < j ) {
                r[(rd%len)] = j+len ;
                rd++ ;
            } else {
                d[(dd%len)] = i+len ;
                dd++ ;
            }
        }
        return ( rd-re > 0 ) ? "Radiant" : "Dire" ;
    }
}