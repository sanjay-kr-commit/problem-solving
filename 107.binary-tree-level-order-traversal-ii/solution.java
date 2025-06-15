// @leet start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null)
      return new ArrayList<>();
    ArrayList<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      ArrayList<Integer> level = new ArrayList<>();
      Queue<TreeNode> nextLevel = new ArrayDeque<>();
      while (!queue.isEmpty()) {
        TreeNode t = queue.poll();
        level.add(t.val);
        if (t.left != null)
          nextLevel.add(t.left);
        if (t.right != null)
          nextLevel.add(t.right);
      }
      ans.add(level);
      queue = nextLevel;
    }
    Collections.reverse(ans);
    return ans;
  }
}

// @leet end
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
