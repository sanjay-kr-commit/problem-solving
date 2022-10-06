class Solution {

    int maxDepth = 0 ;

    public void getDepth( TreeNode node , int depth ) {
        if ( node == null ) return ;
        if ( node.left == null && node.right == null ) {
            if ( maxDepth < depth ) maxDepth = depth ;    
        } else {
            getDepth( node.left , depth+1 );
            getDepth(node.right, depth+1);
        }
    }

    public int maxDepth(TreeNode root) {
        getDepth( root , 1 );
        return maxDepth ;
    }
}