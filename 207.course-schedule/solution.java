import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// @leet start
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<HashSet<Integer>> edges = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++)
      edges.add(new HashSet<>());
    for (int[] prerequisite : prerequisites)
      edges.get(prerequisite[0]).add(prerequisite[1]);
    boolean[] visited = new boolean[numCourses];
    boolean isPossible = true;
    for (int i = 0; i < numCourses && isPossible; i++) {
      isPossible = canFinish2(i, edges, visited, new HashSet<>());
    }
    return isPossible;
  }

  boolean canFinish2(int node, List<HashSet<Integer>> edges, boolean[] visited, HashSet<Integer> path) {
    if (path.contains(node))
      return false;
    if (visited[node])
      return true;
    path.add(node);
    visited[node] = true;
    boolean isPossible = true;
    for (int i : edges.get(node)) {
      if (!isPossible)
        break;
      isPossible = canFinish2(i, edges, visited, path);
    }
    path.remove(node);
    return isPossible;
  }
}
// @leet end
