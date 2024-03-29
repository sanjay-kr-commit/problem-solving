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

    long maxProduct = 0 ,
        total = 0 ;
    
    final int mod = 1000000007 ;

    public int maxProduct(TreeNode root) {
        sum( root ) ;
        traverse( root ) ;
        return (int)( maxProduct % mod ) ;
    }

    void sum( TreeNode node ) {
        if ( node == null ) return ;
        total += node.val ;
        sum( node.left ) ;
        sum( node.right ) ;
    }

    long traverse(TreeNode node ) {
        if ( node == null ) return 0 ;
        long localSum = node.val + traverse( node.left ) + traverse( node.right ) ;
        long localProduct = ( total - localSum ) * localSum ;
        if ( localProduct > maxProduct ) maxProduct = localProduct ;
        return localSum ;
    }

}
