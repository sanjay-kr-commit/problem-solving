// @leet start
class Solution {
  public int maxAdjacentDistance(int[] nums) {
    int max = Math.abs(nums[0] - nums[nums.length - 1]);
    for (int i = 0, len = nums.length - 1; i < len; i++) {
      max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
    }
    return max;
  }
}
// @leet end
