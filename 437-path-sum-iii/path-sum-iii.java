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

    int [] cache = new int [1000];
    int cl = 0 ;

    int paths = 0 ;
    public int pathSum(TreeNode root, int targetSum) {
        if ( root != null ) {
            sum( root , targetSum , 0 ) ;
        }
        return paths ;
    }
    void sum( TreeNode node , int targetSum , long sum ) {
        if ( node == null ) return ;
        long lSum = sum + node.val;
        if ( lSum == targetSum ) paths++ ;
        for ( int i = 0 ; i < cl ; i++ ) {
            lSum -= cache[i];
            if ( lSum == targetSum ) paths++ ;
        }
        cache[cl++] = node.val;
        sum( node.left , targetSum , sum+node.val ) ;
        sum( node.right , targetSum , sum+node.val ) ;
        cl-- ;
    }
}
