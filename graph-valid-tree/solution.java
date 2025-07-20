import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
  public boolean validTree(int n, int[][] edges) {
    ArrayList<HashSet<Integer>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      graph.add(new HashSet<>());
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    HashSet<Integer> visited = new HashSet<>();
    if (!dfs(graph, 0, -1, visited))
      return false;
    return visited.size() == n;
  }

  boolean dfs(List<HashSet<Integer>> graph, int node, int prev, HashSet<Integer> visited) {
    if (visited.contains(node))
      return false;
    visited.add(node);
    for (int i : graph.get(node)) {
      if (i == prev)
        continue;
      if (!dfs(graph, i, node, visited))
        return false;
    }
    return true;
  }
}
