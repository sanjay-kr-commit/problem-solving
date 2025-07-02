// @leet start
class Solution {
  public boolean exist(char[][] board, String word) {
    int len = word.length();
    if (len < 1)
      return true;

    char start = word.charAt(0);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != start)
          continue;
        if (isFound(board, word, 0, len, i, j))
          return true;
      }
    }
    return false;
  }

  boolean isFound(char[][] board, String word, int index, int len, int i, int j) {
    if (index == len)
      return true;
    if (index > len)
      return false;
    if (i == -1 || j == -1 || i == board.length || j == board[i].length)
      return false;
    if (board[i][j] == '#')
      return false;
    char c = word.charAt(index++);
    if (board[i][j] != c)
      return false;
    board[i][j] = '#';
    boolean res = isFound(board, word, index, len, i + 1, j) || isFound(board, word, index, len, i, j + 1)
        || isFound(board, word, index, len, i - 1, j) || isFound(board, word, index, len, i, j - 1);
    board[i][j] = c;
    return res;
  }
}
// @leet end
