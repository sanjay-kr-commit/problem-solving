// @leet start
class Solution {

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != '1')
          continue;
        eraseIsland(grid, i, j);
        count++;
      }
    }
    return count;
  }

  void eraseIsland(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1')
      return;
    grid[i][j] = '#';
    eraseIsland(grid, i + 1, j);
    eraseIsland(grid, i - 1, j);
    eraseIsland(grid, i, j + 1);
    eraseIsland(grid, i, j - 1);
  }

}
// @leet end
