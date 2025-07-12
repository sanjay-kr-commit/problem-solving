import java.util.Arrays;

// @leet start
class Solution {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, -1);
    return helper(coins, amount, dp);
  }

  public int helper(int[] coins, int amount, int[] dp) {
    if (amount == 0)
      return 0;
    if (amount < 0)
      return -1;
    if (dp[amount] != -1)
      return dp[amount];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int minC = Math.min(
          min,
          helper(coins, amount - coin, dp));
      if (minC != -1)
        min = minC;
    }
    dp[amount] = (min == Integer.MAX_VALUE) ? -1 : (min + 1);
    return dp[amount];
  }

}
// @leet end
