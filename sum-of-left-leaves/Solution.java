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
  
  int sum = 0 ;

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0 ;
        add( root , true ) ;
        return sum ;
    }
    
    public void add( TreeNode node , boolean right ) {
      if ( node == null ) return ;
      if ( !right && node.left == null && node.right == null ) sum += node.val ;
      add( node.left , false ) ;
      add( node.right , true ) ;
    }

}
