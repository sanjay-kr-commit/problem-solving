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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
       return addOneRow( root , val , depth , true ) ;
    }
    private TreeNode addOneRow( TreeNode root , int val , int depth , boolean left ) {
        if ( root == null && depth == 1 ) return new TreeNode( val ) ;
        if ( root == null || depth == 0 ) return root ;
        if ( depth == 1 ) {
            TreeNode newNode = new TreeNode( val ) ;
            if ( left ) newNode.left = root ;
            else newNode.right = root ;
            return newNode ;
        } 
        root.left = addOneRow( 
            root.left , val , depth-1 , true 
        );
        root.right = addOneRow( 
            root.right , val , depth-1 , false 
        );
        return root ;
    }
}