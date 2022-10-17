import java.util.ArrayList;
import java.util.List;

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

// 0ms
class Solution {

    List<Integer> list = new ArrayList<>();

    public void traverse( TreeNode node ) {
        if ( node == null ) return ;
        traverse(node.left); 
        traverse(node.right);
        list.add( node.val ) ;      
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse( root ) ;
        return list ;    
    }
}