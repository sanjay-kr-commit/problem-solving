import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

  static class triplet {
    int i, j, val;

    public triplet(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }
  }

  public void islandsAndTreasure(int[][] grid) {

    PriorityQueue<triplet> pq = new PriorityQueue<>(Comparator.comparing(a -> a.val));
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0)
          pq.offer(new triplet(i, j, 0));
      }
    }

    while (!pq.isEmpty()) {
      triplet t = pq.poll();
      t.val++;
      t.i--;
      if (t.i > -1 && grid[t.i][t.j] > t.val) {
        grid[t.i][t.j] = t.val;
        pq.offer(new triplet(t.i, t.j, t.val));
      }
      t.i += 2;
      if (t.i < grid.length && grid[t.i][t.j] > t.val) {
        grid[t.i][t.j] = t.val;
        pq.offer(new triplet(t.i, t.j, t.val));
      }
      t.i--;
      t.j--;
      if (t.j > -1 && grid[t.i][t.j] > t.val) {
        grid[t.i][t.j] = t.val;
        pq.offer(new triplet(t.i, t.j, t.val));
      }
      t.j += 2;
      if (t.j < grid[t.i].length && grid[t.i][t.j] > t.val) {
        grid[t.i][t.j] = t.val;
        pq.offer(new triplet(t.i, t.j, t.val));
      }
    }

  }

}
