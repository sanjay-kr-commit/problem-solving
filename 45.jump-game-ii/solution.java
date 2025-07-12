// @leet start
class Solution {
  public int jump(int[] nums) {
    int jumps = 0;
    int l = 0;
    int r = 0;
    while (r < nums.length - 1) {
      int farthest = maxInRange(nums, l, r);
      l = r + 1;
      r = farthest;
      jumps++;
    }
    return jumps;
  }

  int maxInRange(int[] nums, int l, int r) {
    int maxCount = 0;
    for (int i = l; i <= r; i++) {
      maxCount = Math.max(maxCount, i + nums[i]);
    }
    return maxCount;
  }
}
// @leet end
