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
// 4 ms
class Solution {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return ( root != null && subRoot != null ) ? scanTree( root , subRoot ) : false ;
  }

  private boolean scanTree( TreeNode parent , TreeNode child ) {
    if ( parent == null ) return false ;
    if ( parent.val == child.val && equateSubtree( parent , child ) ) return true ;
    return scanTree( parent.left , child ) || scanTree( parent.right , child ) ; 
  }

  private boolean equateSubtree( TreeNode parent , TreeNode child ) {
    if ( parent == null && child == null ) return true ;
    if ( parent == null || child == null ) return false ;
    boolean left = equateSubtree( parent.left , child.left ) ,
    right = equateSubtree( parent.right , child.right ) ,
    head = parent.val == child.val ;
    return (head && left && right) ;
  }

}
