class Solution {

    public boolean findTarget(TreeNode root, int k) {
        return findTargetSum( root , root , k ) ;
    }

    boolean findTargetSum( TreeNode root , TreeNode node , int k ) {
        if ( node == null ) return false ;
        if ( findTargetSum( root , node.left , k ) || findTargetSum( root , node.right , k ) ) return true ;
        int check=k-node.val;
        if ( node.val != check ) {
            return findX(root, check);
        }
        return false ;
    }

    boolean findX( TreeNode root , int x ) {
        if ( root == null ) return false ;
        if ( root.val == x ) return true ;
        return ( root.val < x ) ? findX( root.right , x ) : findX( root.left , x ) ;
    }

}