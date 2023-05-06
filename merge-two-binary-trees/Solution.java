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
// 1ms
class Solution {
  
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    return mergeTreeHelper( root1 , root2 ) ;
  }
  
  private TreeNode mergeTreeHelper( TreeNode root1 , TreeNode root2 ) {
    if ( root1 == null && root2 == null ) return null ;
    int sum = (( root1 != null ) ? root1.val : 0 )+(( root2 != null ) ? root2.val : 0 );
    TreeNode node = new TreeNode( sum ) ;
    node.left = mergeTreeHelper( ( root1 == null ) ? null : root1.left , ( root2 == null ) ? null : root2.left ) ;
    node.right = mergeTreeHelper( ( root1 == null ) ? null : root1.right , ( root2 == null ) ? null : root2.right ) ;
    return node ;
  }

}
