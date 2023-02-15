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
// 16 ms
class Solution {

  int longest = Integer.MIN_VALUE ;

  public int diameterOfBinaryTree(TreeNode root) {
    traverse(root);
    return longest ;
  }

  public void traverse( TreeNode node ) {
    if ( node == null ) return ;
    int new_max = longestPath( node.left , 0 ) + longestPath( node.right , 0 ) ;
    longest = longest > new_max ? longest : new_max ;
    traverse(node.left);
    traverse(node.right);
  }

  public int longestPath( TreeNode node , int count ) {
    if ( node == null ) return count ;
    int l = longestPath( node.left , count+1 ) , r = longestPath( node.right , count+1 ) ;
    return l < r ? r : l ;
  }
}

// 0ms
class Solution2 {

  int ans = 0 ;

  public int diameterOfBinaryTree( TreeNode root ) {
    
    if ( root != null ) findDiamteterOf( root );
    return ans ;

  }

  public int findDiamteterOf( TreeNode node ) {
    
    if ( node == null ) return -1 ;

    int left = findDiamteterOf( node.left) + 1 ,
    right = findDiamteterOf( node.right ) + 1 ,
    sum = left + right ;
    
    ans = ans > sum ? ans : sum ;

    return left > right ? left : right ;

  }

}
