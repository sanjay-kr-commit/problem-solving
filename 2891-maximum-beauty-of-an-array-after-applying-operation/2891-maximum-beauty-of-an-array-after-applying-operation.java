class Solution {
  public int maximumBeauty(int[] nums, int k) {
    Arrays.sort(nums) ;
    int max = 0 , start = 0 ;
    for (int i = 0; i < nums.length; i++ ) {
      while ( nums[i] - nums[start] > 2*k ) start++ ;
      max = Math.max( max , i-start+1);
    }
    return max ;
  }
}

