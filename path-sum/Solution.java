class Solution {

    boolean PathSum = false ;

    public void check( TreeNode node , int sum , int target ) {
        if ( node == null || PathSum ) return ;
        sum += node.val ;
        if ( node.left == null && node.right == null && sum == target ) {
            PathSum = true ;
            return ;
        }
        check( node.left , sum , target ) ;
        check( node.right , sum , target ) ;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        check( root , 0 , targetSum ) ;
        return PathSum ;
    }
}