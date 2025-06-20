import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

// @leet start
class Solution {
  public long kthLargestLevelSum(TreeNode root, int k) {
    if (root == null)
      return -1;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (Long.compare(a, b)));
    while (!q.isEmpty()) {
      int n = q.size();
      long sum = 0l;
      for (int i = 0; i < n; i++) {
        TreeNode cur = q.poll();
        sum += cur.val;

        if (cur.left != null)
          q.add(cur.left);
        if (cur.right != null)
          q.add(cur.right);
      }

      if (pq.size() < k)
        pq.add(sum);
      else if (pq.peek() < sum) {
        pq.poll();
        pq.add(sum);
      }
    }

    if (pq.size() < k)
      return -1;
    return pq.poll();
  }
}
// @leet end
