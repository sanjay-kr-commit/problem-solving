class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0 ,
            l = a.length()-1 ,
            r = b.length()-1 ;
        while ( l > -1 && r > -1 ) {
            carry += a.charAt( l-- ) - '0' ;
            carry += b.charAt( r-- ) - '0' ;
            sb.append( carry % 2 ) ;
            carry = carry / 2 ;
        }
        while ( l > -1 ) {
            carry += a.charAt( l-- ) - '0' ;
            sb.append( carry % 2 ) ;
            carry = carry / 2 ;
        }
        while ( r > -1 ) {
            carry += b.charAt( r-- ) - '0' ;
            sb.append( carry % 2 ) ;
            carry = carry / 2 ;
        }
        if ( carry > 0 ) sb.append( carry ) ;
        sb.reverse() ;
        return sb.toString() ;
    }
}