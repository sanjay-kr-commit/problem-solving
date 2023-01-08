class Solution {
    public String toHex(int num) {
      if ( num == 0 ) return "0" ;
      StringBuilder hex = new StringBuilder() ;
      char hexChar[] = { '0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , 'a' , 'b' , 'c' , 'd' , 'e' , 'f' } ;
      while ( num != 0 ) {
        // 15 is equivalent to 1111
        hex.append( hexChar[ (num & 15) ] ) ;
        num = num >>> 4 ;
      }
      return hex.reverse().toString() ;
    }
}
