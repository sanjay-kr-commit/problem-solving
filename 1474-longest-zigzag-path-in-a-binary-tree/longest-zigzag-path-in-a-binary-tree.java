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
    int maxLen = 0 ;
    public int longestZigZag(TreeNode root) {
        maxZigZag( root , true , 0 );
        return maxLen ;
    }

    // if direction is true, then we traverse left
    void maxZigZag( TreeNode node , boolean direction , int length ) {
        if ( node == null ) return;
        maxLen = ( maxLen < length ) ? length : maxLen ;
        if ( direction ) {
            maxZigZag( node.left , false , length + 1 ) ;
            maxZigZag( node.right , true , 1 ) ;
        } else {
            maxZigZag( node.right , true , length + 1 ) ;
            maxZigZag( node.left , false ,  1 ) ;
        }
    }

}