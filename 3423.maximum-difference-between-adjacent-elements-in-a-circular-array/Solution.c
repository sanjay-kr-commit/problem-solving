// @leet start
int abs(int a) { return (a > -1) ? a : (a * -1); }
int maxAB(int a, int b) { return (a > b) ? a : b; }
int maxAdjacentDistance(int *nums, int numsSize) {
  int max = abs(nums[0] - nums[numsSize - 1]);
  for (int i = 0, len = numsSize - 1; i < len; i++) {
    max = maxAB(max, abs(nums[i] - nums[i + 1]));
  }
  return max;
}
// @leet end
