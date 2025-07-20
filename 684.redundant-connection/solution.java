// @leet start
class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[edges.length + 1], rank = new int[parent.length];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
    for (int[] edge : edges) {
      if (!union(parent, rank, edge))
        return edge;
    }
    return new int[0];
  }

  boolean union(int[] parent, int[] rank, int[] edge) {
    int p1 = find(edge[0], parent), p2 = find(edge[1], parent);
    if (p1 == p2)
      return false;
    if (rank[p1] > rank[p2]) {
      parent[p2] = p1;
      rank[p1]++;
    } else {
      parent[p1] = p2;
      rank[p2]++;
    }
    return true;
  }

  int find(int node, int[] parent) {
    while (node != parent[node]) {
      parent[node] = parent[parent[node]];
      node = parent[node];
    }
    return node;
  }

}
// @leet end
