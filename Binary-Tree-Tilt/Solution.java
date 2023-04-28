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

  int tilt = 0 ;

  public int findTilt(TreeNode root) {
    calculateTilt( root ) ;
    return tilt ;
  }

  public int calculateTilt(TreeNode root) {

    if ( root == null ) return 0 ;

    int leftSubtreeTilt = calculateTilt( root.left ) ,
    rightSubtreeTilt = calculateTilt( root.right ) ;

    if ( root.left != null ) leftSubtreeTilt += root.left.val ;
    if ( root.right != null ) rightSubtreeTilt += root.right.val ;

    int diff = leftSubtreeTilt - rightSubtreeTilt ;

    tilt += ( diff < 0 ) ? diff * -1 : diff ;
    return leftSubtreeTilt + rightSubtreeTilt ;
  }

}
