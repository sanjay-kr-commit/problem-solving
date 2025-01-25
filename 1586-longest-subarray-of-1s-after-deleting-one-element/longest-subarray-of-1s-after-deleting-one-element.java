class Solution {
  public int longestSubarray(int[] nums) {
    int [] sum = new int [ nums.length ] ;
    int len = 0 ;
    int maxLen = 0 ;
    int lSum = 0 ;
    for ( int i = 0 ; i < nums.length ; i++ ) {
      if ( nums[i] == 1 ) {
        lSum++ ;
        continue ;
      }
      if ( len > 0 ) sum[len-1] += lSum ;
      sum[len++] = lSum ;
      lSum = 0 ;
    }
    if ( len > 0 && nums[nums.length-1] == 1 && lSum != 0 ) sum[len-1] += lSum ;
    else if ( len == 0 ) sum[len++] = lSum-1 ;
    for ( int i = 0 ; i < len ; i++ ) {
      maxLen = ( maxLen < sum[i] ) ? sum[i] : maxLen ;
    }
    return maxLen ;
  }
}
