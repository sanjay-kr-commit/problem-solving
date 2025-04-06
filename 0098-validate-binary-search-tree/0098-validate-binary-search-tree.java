import java.util.HashSet;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper( root , root , new HashSet<>() ) ;
    }
    boolean helper(TreeNode node , TreeNode root , HashSet<Integer> exists ) {
        if ( node == null ) return true;
        if ( exists.contains(node.val) ) return false;
        exists.add(node.val);
        return checkPath( node , root ) && helper( node.left , root , exists ) && helper( node.right , root , exists ) ;
    }

    boolean checkPath( TreeNode node , TreeNode root ) {
        if ( root == null ) return false ;
        if ( node == root ) return true;
        return checkPath( node , ( node.val < root.val ) ? root.left : root.right ) ;
    }
}
