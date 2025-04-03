class Solution {
  public long maximumTripletValue(int[] nums) {
    long res = 0 ;
    int max = 0 , dmax = 0 ;
    for ( int num : nums )  {
      res = Math.max( res , (long) dmax * num ) ;
      dmax = Math.max(dmax, max-num) ;
      max = Math.max(max, num) ;
    }
    return res ;
  }
}
