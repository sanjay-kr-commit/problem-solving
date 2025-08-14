// @leet start
class Solution {
  public void rotate(int[][] matrix) {
    int side = matrix.length;
    for (int offset = 0; offset < side / 2; offset++) {
      int ringSide = side - offset * 2 - 1;
      for (int i = 0; i < ringSide; i++) {
        // top left and top right
        matrix[offset][offset + i] += matrix[offset + i][offset + ringSide];
        matrix[offset + i][offset + ringSide] = matrix[offset][offset + i] - matrix[offset + i][offset + ringSide];
        matrix[offset][offset + i] = matrix[offset][offset + i] - matrix[offset + i][offset + ringSide];
        // top left and bottom right
        matrix[offset][offset + i] += matrix[offset + ringSide][offset + ringSide - i];
        matrix[offset + ringSide][offset + ringSide - i] = matrix[offset][offset + i]
            - matrix[offset + ringSide][offset + ringSide - i];
        matrix[offset][offset + i] = matrix[offset][offset + i] - matrix[offset + ringSide][offset + ringSide - i];
        // top left and bottom left
        matrix[offset][offset + i] += matrix[offset + ringSide - i][offset];
        matrix[offset + ringSide - i][offset] = matrix[offset][offset + i] - matrix[offset + ringSide - i][offset];
        matrix[offset][offset + i] = matrix[offset][offset + i] - matrix[offset + ringSide - i][offset];
      }
    }
  }
}
// @leet end
