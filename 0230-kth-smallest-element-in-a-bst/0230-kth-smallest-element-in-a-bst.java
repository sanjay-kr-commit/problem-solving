class Solution {

    public int kthSmallest(TreeNode root, int k) {
        int [] result = new int[2];
        result[0] = k;
        traverse(root, result);
        return result[1];
    }
    void traverse( TreeNode node , int [] result ) {
        if ( node == null ) return;
        traverse(node.left, result);
        result[0]--;
        if ( result[0] == 0 ) result[1] = node.val;
        traverse(node.right, result);
    }
}
