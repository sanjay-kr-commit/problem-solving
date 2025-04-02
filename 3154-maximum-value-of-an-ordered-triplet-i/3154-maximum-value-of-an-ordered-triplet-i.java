class Solution {
  public long maximumTripletValue(int[] nums) {
    long result = 0 ;
    int max = 0 , subtractedMax = 0 ;
    for ( int num : nums ) {
      result = Math.max( result , (long) subtractedMax * num ) ;
      subtractedMax = Math.max( subtractedMax , max - num ) ;
      max = Math.max( max , num ) ;
    }
    return result ;
  }
}
