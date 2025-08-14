import java.util.PriorityQueue;

// @leet start

class Solution {
  public int longestIncreasingPath(int[][] matrix) {
    int max = 1;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        pq.add(new int[] { i, j, matrix[i][j] });
      }
    }
    int[][] cache = new int[matrix.length][matrix[0].length];
    while (!pq.isEmpty()) {
      int[] pop = pq.poll();
      int i = pop[0], j = pop[1], w = pop[2];
      int localMax = 0;
      if (i > 0 && matrix[i - 1][j] > w)
        localMax = Math.max(localMax, cache[i - 1][j]);
      if (i < matrix.length - 1 && matrix[i + 1][j] > w)
        localMax = Math.max(localMax, cache[i + 1][j]);
      if (j > 0 && matrix[i][j - 1] > w)
        localMax = Math.max(localMax, cache[i][j - 1]);
      if (j < matrix[0].length - 1 && matrix[i][j + 1] > w)
        localMax = Math.max(localMax, cache[i][j + 1]);
      cache[i][j] += localMax + 1;
      max = Math.max(max, cache[i][j]);
    }
    return max;
  }
}
// @leet end
