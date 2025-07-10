import java.util.Arrays;

// @leet start
class Solution {

  public int numDecodings(String s) {
    int[] dp = new int[s.length()];
    Arrays.fill(dp, -1);
    return numDecodings(s, 0, s.length() - 1, dp);
  }

  int numDecodings(String s, int index, int len, int[] dp) {
    if (index > len)
      return 1;
    char ch = s.charAt(index);
    if (ch == '0')
      return 0;
    if (dp[index] != -1)
      return dp[index];
    dp[index] = numDecodings(s, index + 1, len, dp);
    if (index < len) {
      int check = ch - '0';
      check *= 10;
      check += s.charAt(index + 1) - '0';
      if (check < 10 || check > 26)
        return dp[index];
      dp[index] += numDecodings(s, index + 2, len, dp);
    }
    return dp[index];
  }
}
// @leet end
