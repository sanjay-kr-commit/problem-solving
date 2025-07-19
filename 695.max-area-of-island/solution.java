// @leet start
class Solution {
  public int maxAreaOfIsland(int[][] grid) {
    int area = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != 1)
          continue;
        area = Math.max(area, area(grid, i, j));
      }
    }
    return area;
  }

  int area(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1)
      return 0;
    grid[i][j] = -1;
    int count = 1;
    count += area(grid, i + 1, j);
    count += area(grid, i - 1, j);
    count += area(grid, i, j + 1);
    count += area(grid, i, j - 1);
    return count;
  }

}
// @leet end
