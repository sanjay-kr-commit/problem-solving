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
import java.util.* ;
class Solution {
  public int maxLevelSum(TreeNode root) {
    ArrayList<Long> levelSum = new ArrayList<>() ;
    levelSum( root , 0 , levelSum ) ;
    long max = Long.MIN_VALUE ;
    int index = -1 ;
    for ( int i = 0 ; i < levelSum.size() ; i++ ) {
      if ( levelSum.get(i) < max || ( levelSum.get(i) == max && index > -1 ) ) continue ;
      max = levelSum.get( i ) ;
      index = i ;
    }
    return index+1 ;
  }
  
  void levelSum( TreeNode node , int level , ArrayList<Long> levelSum ) {
    if ( node == null ) return ;
    if ( level == levelSum.size() ) levelSum.add( 0L ) ;
    levelSum.set( level , levelSum.get( level ) + node.val ) ;
    levelSum( node.left , level + 1 , levelSum ) ;
    levelSum( node.right , level + 1 , levelSum ) ;
  }
}
