import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

// @leet start

class Solution {

  public int minCostConnectPoints(int[][] points) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    int time = 0;
    pq.add(new int[] { 0, 0 });
    HashSet<Integer> visited = new HashSet<>();
    while (visited.size() < points.length) {
      int[] node = pq.poll();
      if (visited.contains(node[1]))
        continue;
      visited.add(node[1]);
      time += node[0];
      if (visited.size() == points.length)
        break;
      for (int i = 0; i < points.length; i++) {
        if (visited.contains(i))
          continue;
        pq.add(new int[] {
            Math.abs(points[node[1]][0] - points[i][0]) + Math.abs(points[node[1]][1] - points[i][1]),
            i
        });
      }
    }
    return time;
  }
}
// @leet end
