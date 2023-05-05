class Solution {
    public int maxCount(int m, int n, int[][] ops) {
    if ( ops.length == 0 ) return m*n ;
    int min_x = Integer.MAX_VALUE , min_y = min_x ;
    for ( int[] op : ops ) {
      if ( op[0] < min_x ) min_x = op[0] ;
      if ( op[1] < min_y ) min_y = op[1] ;
    }
    return ( min_x == 0 && min_y == 0 ) ? m*n : min_x * min_y ;
  }
}
