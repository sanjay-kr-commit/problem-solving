import java.util.Arrays;
import java.util.HashMap;

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

    long [] sum ;
    public long kthLargestLevelSum(TreeNode root, int k) {
        sum = new long[depth( root, 0 )] ;
        if ( k > sum.length ) return -1 ;
        sum( root, 0 ) ;
        Arrays.sort( sum );
        return sum[ sum.length - k  ] ;
    }

    int depth( TreeNode node , int level ) {
        if ( node == null ) return level ;
        return Math.max(depth(node.left , level+1), depth(node.right , level+1)) ;
    }

    void sum( TreeNode node , int level ) {
        if ( node == null ) return;
        sum[level] += node.val;
        sum( node.left , level+1 ) ;
        sum( node.right , level+1 ) ;
    }

}