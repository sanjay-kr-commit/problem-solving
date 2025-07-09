import java.util.Arrays;

// @leet start

class Solution {
  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return rob(0, nums, 0, dp);
  }

  int rob(int index, int[] nums, int sum, int[] dp) {
    if (index >= nums.length)
      return sum;
    if (dp[index] != -1)
      return dp[index] + sum;
    dp[index] = Math.max(rob(index + 1, nums, 0, dp), rob(index + 2, nums, nums[index], dp));
    return dp[index] + sum;
  }
}
// @leet end
