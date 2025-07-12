// @leet start

import java.util.Arrays;

class Solution {
  public int lengthOfLIS(int[] nums) {
    int max = 0;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    for (int i = 0; i < nums.length; i++)
      max = Math.max(max, max(nums, i, nums.length, dp) + 1);
    return max;
  }

  int max(int[] nums, int index, int len, int[] dp) {
    if (index >= len)
      return 0;
    if (dp[index] != -1)
      return dp[index];
    int max = 0;
    for (int i = index + 1; i < len; i++) {
      if (nums[index] < nums[i])
        max = Math.max(max, max(nums, i, len, dp) + 1);
    }
    dp[index] = max;
    return max;
  }
}
// @leet end
