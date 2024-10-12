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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>() ;
        leafNode( root1 , list1 ) ;
        ArrayList<Integer> list2 = new ArrayList<>() ;
        leafNode( root2 , list2 ) ;
        if ( list1.size() != list2.size() ) return false ;
        boolean isEqual = true ;
        System.out.println( list1.size() );
        System.out.println( list2.size() );
        for ( int i = 0 , len = list1.size(); i < len && isEqual ; i++ ) {
            isEqual = list1.get(i).equals(list2.get(i)) ;
        }
        return isEqual;
    }

    void leafNode(TreeNode node , ArrayList<Integer> list ) {
        if ( node == null ) return  ;
        leafNode( node.left , list ) ;
        if ( node.left == null && node.right == null ) list.add( node.val ) ;
        leafNode( node.right , list ) ;
    }

}