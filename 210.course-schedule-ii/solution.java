import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// @leet start
class Solution {

  int i;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    i = 0;
    ArrayList<HashSet<Integer>> graph = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++)
      graph.add(new HashSet<>());
    for (int[] prerequisite : prerequisites)
      graph.get(prerequisite[0]).add(prerequisite[1]);
    int[] order = new int[numCourses];
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!findOrder2(i, graph, order, visited, new HashSet<Integer>()))
        return new int[0];
    }
    return order;
  }

  boolean findOrder2(int node, List<HashSet<Integer>> graph, int[] order, boolean[] visited, HashSet<Integer> path) {
    if (path.contains(node))
      return false;
    if (visited[node])
      return true;
    visited[node] = true;
    path.add(node);
    boolean isPossible = true;
    for (int i : graph.get(node)) {
      if (!isPossible)
        break;
      isPossible = findOrder2(i, graph, order, visited, path);
    }
    path.remove(node);
    order[i++] = node;
    return isPossible;
  }

}
// @leet end
