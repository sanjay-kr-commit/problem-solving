// @leet start
class Solution {
  public void setZeroes(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] cols = new boolean[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        rows[i] |= matrix[i][j] == 0;
        cols[j] |= matrix[i][j] == 0;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      if (!rows[i])
        continue;
      for (int j = 0; j < matrix[0].length; j++)
        matrix[i][j] = 0;
    }
    for (int j = 0; j < matrix[0].length; j++) {
      if (!cols[j])
        continue;
      for (int i = 0; i < matrix.length; i++)
        matrix[i][j] = 0;
    }
  }
}
// @leet end
