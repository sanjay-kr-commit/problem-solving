// @leet start

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int minimumEffortPath(int[][] heights) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
    pq.add(new int[] { heights.length - 1, heights[0].length - 1, 0 });
    int max = 0;
    boolean[][] visited = new boolean[heights.length][heights[0].length];
    while (!pq.isEmpty()) {
      int[] pop = pq.poll();
      max = Math.max(max, pop[2]);
      if (pop[0] == 0 && pop[1] == 0)
        break;
      if (pop[0] < 0 || pop[1] < 0)
        continue;
      if (visited[pop[0]][pop[1]])
        continue;
      visited[pop[0]][pop[1]] = true;
      if (pop[0] > 0)
        pq.add(new int[] { pop[0] - 1, pop[1], Math.abs(heights[pop[0] - 1][pop[1]] - heights[pop[0]][pop[1]]) });
      if (pop[1] > 0)
        pq.add(new int[] { pop[0], pop[1] - 1, Math.abs(heights[pop[0]][pop[1] - 1] - heights[pop[0]][pop[1]]) });
      if (pop[0] + 1 < heights.length)
        pq.add(new int[] { pop[0] + 1, pop[1], Math.abs(heights[pop[0] + 1][pop[1]] - heights[pop[0]][pop[1]]) });
      if (pop[1] + 1 < heights[0].length)
        pq.add(new int[] { pop[0], pop[1] + 1, Math.abs(heights[pop[0]][pop[1] + 1] - heights[pop[0]][pop[1]]) });
    }
    return max;
  }
}
// @leet end
