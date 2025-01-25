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
  int goodNodes ;
  public int goodNodes(TreeNode root) {
    goodNodes = 0 ;
    if ( root != null ) count( root , Integer.MIN_VALUE ) ;
    return goodNodes ;
  }

  void count( TreeNode node , int max ) {
    if ( node == null ) return ;
    if ( max <= node.val ) goodNodes++ ;
    max = ( max < node.val ) ? node.val : max ;
    count( node.left , max ) ;
    count( node.right , max ) ;
  }

}