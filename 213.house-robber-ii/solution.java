
// @leet imports start
import java.util.*;
import java.math.*;
// @leet imports end

// @leet start

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    int ans = rob(0, nums, nums.length - 1, 0, dp);
    Arrays.fill(dp, -1);
    ans = Math.max(ans, rob(1, nums, nums.length, 0, dp));
    return ans;
  }

  int rob(int index, int[] nums, int len, int sum, int[] dp) {
    if (index >= len)
      return sum;
    if (dp[index] != -1)
      return dp[index] + sum;
    dp[index] = Math.max(rob(index + 1, nums, len, 0, dp), rob(index + 2, nums, len, nums[index], dp));
    return dp[index] + sum;
  }
}

// @leet end
