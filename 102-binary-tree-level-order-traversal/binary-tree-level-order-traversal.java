import java.lang.reflect.Array;
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
class Solution { 
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        levelOrder( root , result , 0 );
        ArrayList<List<Integer>> res = new ArrayList<>( result.size() );
        res.addAll(result);
        return res;
    }
    
    void levelOrder(TreeNode node , ArrayList<ArrayList<Integer>> res , int level ) {
        if ( node == null ) return;
        if ( level >= res.size() ) for ( int i = 0 ; i < level-res.size()+1 ; i++ ) {
            res.add( new ArrayList<>() );
        }
        res.get( level ).add( node.val );
        levelOrder( node.left , res , level+1 );
        levelOrder( node.right , res , level+1 );
    }
}