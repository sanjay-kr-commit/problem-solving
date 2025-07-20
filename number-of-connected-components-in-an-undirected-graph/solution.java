import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
  public int countComponents(int n, int[][] edges) {
    ArrayList<HashSet<Integer>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      graph.add(new HashSet<>());
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    int count = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (visited[i])
        continue;
      dfs(graph, i, -1, visited);
      count++;
    }
    return count;
  }

  void dfs(List<HashSet<Integer>> graph, int node, int prev, boolean[] visited) {
    if (visited[node])
      return;
    visited[node] = true;
    for (int i : graph.get(node)) {
      if (i == prev)
        continue;
      dfs(graph, i, node, visited);
    }
  }

}
