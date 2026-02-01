class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    LinkedList<Integer> list = new LinkedList<>();
    int x = 0, y = 1, count = matrix.length * matrix[0].length;
    for (int i = 0, j = 0; count > 0; count--, i += x, j += y) {
      if (x == 0 && y == 1 && (j == matrix[0].length || matrix[i][j] == 101)) {
        j--;
        i++;
        x = 1;
        y = 0;
      } else if (x == 1 && y == 0 && (i == matrix.length || matrix[i][j] == 101)) {
        i--;
        j--;
        y = -1;
        x = 0;
      } else if (x == 0 && y == -1 && (j == -1 || matrix[i][j] == 101)) {
        j++;
        i--;
        x = -1;
        y = 0;
      } else if (x == -1 && y == 0 && (i == -1 || matrix[i][j] == 101)) {
        i++;
        j++;
        x = 0;
        y = 1;
      }
      list.add(matrix[i][j]);
      matrix[i][j] = 101;
    }
    return list;
  }
}