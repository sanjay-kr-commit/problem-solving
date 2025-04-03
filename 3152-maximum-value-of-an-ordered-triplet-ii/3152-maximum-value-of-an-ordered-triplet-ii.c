long long maximumTripletValue(int *nums, int numsSize) {
  long long ans = 0;
  int max = 0, dmax = 0;
  for (int i = 0; i < numsSize; i++) {
    ans =
        (((long long)dmax * nums[i]) < ans) ? ans : ((long long)dmax * nums[i]);
    dmax = ( max-nums[i] > dmax) ? max-nums[i] : dmax ;
    max = ( max > nums[i] ) ? max : nums[i] ;
  }
  return ans;
}
