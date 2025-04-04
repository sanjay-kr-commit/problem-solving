class Solution {
    public void flatten(TreeNode root) {
        flattener( root , false , null );
        invert(root);
    }
    TreeNode flattener(TreeNode node , boolean isRight , TreeNode child ) {
        if ( node == null ) return null;
        if ( node.left == null && node.right != null ) {
            node.left = node.right ;
            node.right = null ;
        }
        flattener( node.left , false , ( node.right == null ) ? child : flattener( node.right , true , child ) );
        if ( node.left == null && node.right == null ) {
            node.left = child ;
        }
        if ( node.left != null) node.right = null ;
        return node ;
    }
    void invert( TreeNode node ) {
        if ( node == null ) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invert( node.left );
        invert( node.right );
    }
}