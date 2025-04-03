class Solution {
  public int missingNumber(int[] nums) {
    int result = 0;
    int max = 0 , min = Integer.MAX_VALUE;
    for ( int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if ( min != 0 ) return 0 ;
    if ( max-min+1 == nums.length ) max++ ;
    max++ ;
    for ( int i = 0 ; i < max ; i++ ) result ^= i ;
    for ( int i : nums ) result ^= i ;
    return result;
  }
}