class Solution {
    public String licenseKeyFormatting(String s, int k) {
      StringBuilder ss = new StringBuilder() ;
      int i = s.length() ;
      int count = 0 ;
      while ( i > 0 ) {
        i-- ;
        char C = s.charAt( i ) ;
        if ( C == '-' ) continue ;
        if ( count == k ) {
            count = 0 ;
            ss.append( "-" ) ;
        }
        if ( C >= 'a' && C <= 'z' ) ss.append( (char)( C - 32 ) ) ;
        else ss.append( C ) ;
        count++ ;
      }
      return ss.reverse().toString() ;
    }
}
