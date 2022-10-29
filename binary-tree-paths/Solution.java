import java.util.ArrayList;
import java.util.LinkedList;
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
// 1ms
//clean code
class Solution {

    List<String> pList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        helper( root , new StringBuilder() ); 
        return pList ;
    }

    public void helper( TreeNode node , StringBuilder path ) {
        if ( node == null ) return ;
        if ( ! path.isEmpty() ) path.append( "->" ) ;
        path.append( node.val ) ;
        if ( node.left == null && node.right == null ) pList.add( path.toString() ) ;
        helper( node.left , new StringBuilder( path ) );
        helper( node.right ,new StringBuilder( path ) );
    }

}

// 3ms
class Solution1 {
     
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if ( root != null ) {
            StringBuilder st = new StringBuilder( root.val ) ;
            if ( root.left == null && root.right == null ) {
                list.add( st.toString() ) ;
            } else {
                helper( root.left , st);
                helper(root.right, new StringBuilder( st ));
            }
        }
        return list ;
    }

    public void helper( TreeNode node , StringBuilder path  ) {
        if ( node == null ) return ;
        path.append( "->" ) ;
        path.append( node.val ) ;
        if ( node.left == null && node.right == null ) {
            list.add( path.toString() ) ;
            return ;
        }
        if ( node.left != null ) helper(node.left, new StringBuilder( path ));
        if ( node.right != null ) helper(node.right, new StringBuilder( path ) );

    }

}