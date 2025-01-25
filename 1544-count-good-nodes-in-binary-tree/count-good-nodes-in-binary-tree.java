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
  public int goodNodes(TreeNode root) {
    return count( root , Integer.MIN_VALUE ) ;
  }

  int count( TreeNode node , int max ) {
    if ( node == null ) return 0 ;
    int lmax = ( max < node.val ) ? node.val : max ;
    return (( max > node.val ) ? 0 : 1 ) +
    count( node.left , lmax ) +
    count( node.right , lmax ) ;
  }

}
