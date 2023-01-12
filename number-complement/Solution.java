class Solution {
    public int findComplement(int num) {
      int bits = 0 ;
      while ( bits < num ) bits = ( bits << 1 ) | 1 ;
      return bits - num ;
    }
}
