// @leet start

import java.util.Stack;

class Solution {

  static class pair {
    int i, j;

    public pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public int orangesRotting(int[][] grid) {
    int time = 0;
    int freshCount = 0;
    Stack<pair> st = new Stack<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1)
          freshCount++;
        else if (grid[i][j] == 2)
          st.add(new pair(i, j));
      }
    }
    if (!st.isEmpty())
      time--;
    while (!st.isEmpty()) {
      Stack<pair> nextIteration = new Stack<>();
      while (!st.isEmpty()) {
        pair p = st.pop();
        p.i--;
        if (p.i > -1 && grid[p.i][p.j] == 1) {
          grid[p.i][p.j] = 2;
          nextIteration.add(new pair(p.i, p.j));
          freshCount--;
        }
        p.i += 2;
        if (p.i < grid.length && grid[p.i][p.j] == 1) {
          grid[p.i][p.j] = 2;
          nextIteration.add(new pair(p.i, p.j));
          freshCount--;
        }
        p.i--;
        p.j--;
        if (p.j > -1 && grid[p.i][p.j] == 1) {
          grid[p.i][p.j] = 2;
          nextIteration.add(new pair(p.i, p.j));
          freshCount--;
        }
        p.j += 2;
        if (p.j < grid[p.i].length && grid[p.i][p.j] == 1) {
          grid[p.i][p.j] = 2;
          nextIteration.add(new pair(p.i, p.j));
          freshCount--;
        }
      }
      st = nextIteration;
      time++;
    }
    return (freshCount == 0) ? time : -1;
  }
}

// @leet end
