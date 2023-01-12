class Solution {
    public int hammingDistance(int x, int y) {
      int diff = 0 , xor = x ^ y ;
      while ( xor != 0 ) {
        if ( xor%2 == 1 ) diff++ ;
        xor = xor >> 1 ;
      }
      return diff ;
    }
}
