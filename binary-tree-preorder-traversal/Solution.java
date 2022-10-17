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

// 0 ms
class Solution {

    List<Integer> list = new ArrayList<>() ;

    public void traverse( TreeNode node ) {
        if ( node == null ) return ;
        list.add(node.val) ;
        traverse(node.left);
        traverse(node.right) ;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list ;
    }
}