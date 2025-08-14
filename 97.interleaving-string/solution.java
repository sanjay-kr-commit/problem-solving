// @leet start
class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int len1 = s1.length(), len2 = s2.length();
    if (len1 + len2 != s3.length())
      return false;
    boolean[][] dp = new boolean[len1 + 1][len2 + 1];
    dp[len1][len2] = true;
    for (int i = len1; i > -1; i--) {
      for (int j = len2; j > -1; j--) {
        if (i < len1 && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
          dp[i][j] = true;
        }
        if (j < len2 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
          dp[i][j] = true;
        }
      }
    }
    return dp[0][0];
  }
}
// @leet end
