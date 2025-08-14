// @leet start
class Solution {
  public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    dp[n - 1] = 1;
    int[] temp = new int[n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = n - 1; j > -1; j--) {
        temp[j] = dp[j] + temp[j + 1];
      }
      for (int j = 0; j < n; j++)
        dp[j] = temp[j];
    }
    return dp[0];
  }
}
// @leet end
