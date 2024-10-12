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
    public int maxDepth(TreeNode root) {
        return maxDepth( root , 0 ) ;
    }
    
    int maxDepth( TreeNode node , int level ) {
        if ( node == null ) return level ;
        return Math.max( maxDepth( node.left , level+1 ) , maxDepth( node.right , level+1 ) ) ; 
    }
}