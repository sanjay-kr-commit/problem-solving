class Solution {
    
    boolean isEqual = true ;

    public void check( TreeNode one , TreeNode two ) {
        if ( !isEqual ) return ;
        if ( one == null && two == null ) return ;
        if ( one == null || two == null || one.val != two.val ){
            isEqual = false ;
            return ;
        }
        check(one.left, two.left);
        check(one.right, two.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        check( p, q);
        return isEqual ;
    }

}