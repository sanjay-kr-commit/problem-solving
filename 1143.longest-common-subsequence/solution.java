// @leet start
class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int[] dp = new int[text1.length()];
    int longest = 0;
    for (char c : text2.toCharArray()) {
      int currentLength = 0;
      for (int i = 0; i < dp.length; i++) {
        if (currentLength < dp[i])
          currentLength = dp[i];
        else if (c == text1.charAt(i)) {
          dp[i] = currentLength + 1;
          longest = Math.max(longest, dp[i]);
        }
      }
    }
    return longest;
  }
}
// @leet end
