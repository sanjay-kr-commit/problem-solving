import java.util.Comparator;
import java.util.PriorityQueue;

// @leet start

class Solution {
  public int swimInWater(int[][] grid) {
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    int[][] directions = new int[][] {
        { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
    };
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    minHeap.offer(new int[] { grid[0][0], 0, 0 });
    visited[0][0] = true;
    while (!minHeap.isEmpty()) {
      int[] point = minHeap.poll();
      int time = point[0], row = point[1], col = point[2];
      if (row == n - 1 && col == n - 1)
        return time;
      for (int[] direction : directions) {
        int nextRow = row + direction[0], nextCol = col + direction[1];
        if (nextRow > -1 && nextCol > -1 && nextRow < n && nextCol < n && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          minHeap.offer(new int[] {
              Math.max(time, grid[nextRow][nextCol]), nextRow, nextCol
          });
        }
      }
    }
    return n * n;
  }
}
// @leet end
