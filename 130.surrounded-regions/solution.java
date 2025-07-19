// @leet start
class Solution {
  public void solve(char[][] board) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 'O' || visited[i][j])
          continue;
        fill(board, i, j, isSurrounded(board, i, j, visited) ? 'X' : 'O');
      }
    }
  }

  void fill(char[][] board, int i, int j, char x) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != '#')
      return;
    board[i][j] = x;
    fill(board, i + 1, j, x);
    fill(board, i - 1, j, x);
    fill(board, i, j + 1, x);
    fill(board, i, j - 1, x);
  }

  boolean isSurrounded(char[][] board, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
      return false;
    visited[i][j] = true;
    if (board[i][j] != 'O')
      return true;
    board[i][j] = '#';
    return isSurrounded(board, i + 1, j, visited) && isSurrounded(board, i - 1, j, visited)
        && isSurrounded(board, i, j + 1, visited)
        && isSurrounded(board, i, j - 1, visited);
  }

}
// @leet end
