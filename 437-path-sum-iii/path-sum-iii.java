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
    class List {
        TreeNode data ;
        List next ;
    }
    int paths = 0 ;
    public int pathSum(TreeNode root, int targetSum) {
        if ( root != null ) {
            List head = new List() ;
            head.data = root ;
            if ( root.val == targetSum ) paths++ ;
            sum( root.left , targetSum , root.val , head , head ) ;
            sum( root.right , targetSum, root.val , head , head ) ;
        }
        return paths ;
    }
    void sum( TreeNode node , int targetSum , long sum , List head , List end ) {
        if ( node == null ) return ;
        List curr = head ;
        long lSum = sum + node.val ;
        if ( lSum == targetSum ) paths++ ;
        while (curr!=null) {
            lSum -= curr.data.val ;
            if ( lSum == targetSum ) paths++ ;
            curr = curr.next ;
        }
        end.next = new List() ;
        end.next.data = node ;
        sum( node.left , targetSum , sum + node.val , head , end.next ) ;
        sum( node.right , targetSum , sum + node.val , head , end.next ) ;
        end.next = null ;
    }
}
