// 1ms
// tail recursive
class Solution1 {
    
    boolean symmetry = true ;

    public void helper( TreeNode left , TreeNode right ) {
        if ( !symmetry ) return ;
        if ( right == null && left == null ) return ;
        else if ( left == null || right == null ) symmetry = false ;
        else if ( left.val != right.val ) symmetry = false ;
        else {
            helper(left.left, right.right);
            helper(left.right, right.left);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if ( root != null ) helper( root.left , root.right ) ;
        return symmetry ;
    }


}

//1 ms
// normal recusion
class Solution {

    public boolean helper( TreeNode left , TreeNode right ) {
        if ( left == null && right == null ) return true ;
        if ( left == null || right == null ) return false ;
        if ( left.val != right.val ) return false ;
        return helper( left.left, right.right ) && helper(left.right, right.left ) ;
    }

    public boolean isSymmetric(TreeNode root) {
         if(root == null) return true ;    
        return helper(root.left , root.right) ;
    }

}