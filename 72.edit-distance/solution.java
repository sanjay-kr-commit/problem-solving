// @leet start
class Solution {
  public int minDistance(String word1, String word2) {
    int word1Len = word1.length(), word2Len = word2.length();
    int[][] cache = new int[word1.length() + 1][word2.length() + 1];
    for (int i = word1Len; i > -1; i--) {
      cache[i][word2Len] = word1Len - i;
    }
    for (int i = word2Len; i > -1; i--) {
      cache[word1Len][i] = word2Len - i;
    }
    for (int i = word1Len - 1; i > -1; i--) {
      for (int j = word2Len - 1; j > -1; j--) {
        if (word1.charAt(i) == word2.charAt(j)) {
          cache[i][j] = cache[i + 1][j + 1];
        } else
          cache[i][j] = Math.min(Math.min(cache[i + 1][j + 1], cache[i + 1][j]),
              cache[i][j + 1]) + 1;

      }
    }
    return cache[0][0];
  }
}
// @leet end
