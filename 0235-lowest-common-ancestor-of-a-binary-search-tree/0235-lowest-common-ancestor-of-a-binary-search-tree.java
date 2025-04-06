/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode [] ans = new TreeNode[1];
        help( root, p, q, ans );
        return ans[0] ;
    }

    int help(TreeNode root, TreeNode p, TreeNode q, TreeNode [] ans ) {
        if ( root == null || ans[0] != null ) return 0;
        int count = help( root.left, p, q, ans ) + help( root.right, p, q, ans ) + (( root.val == p.val || root.val == q.val ) ? 1 : 0);
        if ( count == 2 && ans[0] == null ) ans[0] = root;
        return count ;
    }

}
