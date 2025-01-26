/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode rest ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor2(root, p, q);
        return rest ;
    }

    int lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if ( rest != null || root == null ) return 0 ;
        int sum = ( root == p || root == q ) ? 1 : 0 ;
        sum += lowestCommonAncestor2(root.left, p, q) + lowestCommonAncestor2(root.right, p, q) ;
        if ( sum == 2 && rest == null ) rest = root ;
        return sum ;
    }


}