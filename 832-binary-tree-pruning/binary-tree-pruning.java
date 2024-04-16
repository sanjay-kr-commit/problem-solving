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
    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = new TreeNode();
        node.left = root;
        pruneTreeDFS( node ) ;
        return node.left ;
    }
    boolean pruneTreeDFS( TreeNode root ) {
        if ( root == null ) return false ;
        boolean left = pruneTreeDFS( root.left ) ;
        boolean right = pruneTreeDFS( root.right ) ;
        if ( !left ) root.left = null ;
        if ( !right ) root.right = null ;
        return root.val == 1 || left || right ;
    }
}