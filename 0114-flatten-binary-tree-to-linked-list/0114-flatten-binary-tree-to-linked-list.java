class Solution {
    public void flatten(TreeNode root) {
        flattener( root , false , null );
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
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        return node ;
    }
}