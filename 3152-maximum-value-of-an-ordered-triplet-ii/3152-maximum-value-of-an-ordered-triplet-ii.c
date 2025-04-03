#define max(a, b) (a > b) ? a : b;
long long maximumTripletValue(int *nums, int numsSize) {
  long long ans = 0;
  int max = 0, dmax = 0;
  for (int i = 0; i < numsSize; i++) {
    ans = max(((long long)dmax * nums[i]), ans);
    dmax = max(max - nums[i], dmax);
    max = max(max, nums[i]);
  }
  return ans;
}
