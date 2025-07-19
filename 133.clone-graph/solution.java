import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

// @leet start

class Solution {
  public Node cloneGraph(Node node) {
    if (node == null)
      return null;
    HashMap<Node, Node> cycles = new HashMap<Node, Node>();
    Node clone = new Node();
    cycles.put(node, clone);
    clone(node, clone, cycles);
    return clone;
  }

  void clone(Node node, Node clone, HashMap<Node, Node> cycles) {
    clone.val = node.val;
    for (Node neighbor : node.neighbors) {
      if (cycles.containsKey(neighbor)) {
        clone.neighbors.add(cycles.get(neighbor));
        continue;
      }
      Node neighborClone = new Node();
      cycles.put(neighbor, neighborClone);
      clone.neighbors.add(neighborClone);
      clone(neighbor, neighborClone, cycles);
    }
  }
}
// @leet end
