// @leet start
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    int[] next = new int[amount + 1];
    next[amount] = 1;
    dp[amount] = 1;
    for (int i = coins.length - 1; i > -1; i--) {
      for (int j = amount - 1; j > -1; j--) {
        next[j] = (j + coins[i] > amount) ? 0 : next[j + coins[i]];
        next[j] += dp[j];
      }
      int[] prev = dp;
      dp = next;
      next = prev;
    }
    return dp[0];
  }
}
// @leet end
