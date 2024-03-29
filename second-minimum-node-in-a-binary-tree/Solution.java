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

    Integer first , second ;

    public int findSecondMinimumValue(TreeNode root) {
        first = null ; second = null ;
        helper( root );
        return (second==null)?-1:second ;
    }

    private void helper( TreeNode node ) {
        if ( node == null ) return;
        if ( first == null || node.val < first ) {
            second = first ;
            first = node.val ;
        } else if ( node.val != first && (second == null || node.val < second) ) {
            second = node.val ;
        }
        helper( node.left );
        helper( node.right );
    }
}
