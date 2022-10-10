class Solution {

    boolean bal = true ;

    public boolean isBalanced( TreeNode root ) {
        check( root ) ;
        return bal ;
    }

    public int check( TreeNode node ) {
        if ( node == null ) return 0 ;
        else if ( node.left == null && node.right == null ) return 1 ;
        else {
            int  l = check(node.left) , r = check(node.right) ;
            if ( l-r > 1 || l-r < -1 ) bal = false ;
            return 1 + (( l > r ) ? l : r) ;
        }
    }

}