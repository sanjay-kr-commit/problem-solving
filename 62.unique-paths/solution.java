import java.util.Arrays;

// @leet start

class Solution {
  public int uniquePaths(int m, int n) {
    int[][] cache = new int[m][n];
    for (int[] c : cache)
      Arrays.fill(c, -1);
    uniquePaths(0, 0, m, n, cache);
    return cache[0][0];
  }

  int uniquePaths(int i, int j, int m, int n, int[][] cache) {
    if (i >= m || j >= n)
      return 0;
    if (i == m - 1 && j == n - 1) {
      cache[i][j] = 1;
      return 1;
    }
    if (cache[i][j] != -1)
      return cache[i][j];
    cache[i][j] = uniquePaths(i + 1, j, m, n, cache) + uniquePaths(i, j + 1, m, n, cache);
    return cache[i][j];
  }

}
// @leet end
