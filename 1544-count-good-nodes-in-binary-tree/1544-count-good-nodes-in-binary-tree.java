class Solution {
    public int goodNodes(TreeNode root) {
        int [] ans = new int[1];
        traverse(root, Integer.MIN_VALUE, ans);
        return ans[0] ;
    }

    private void traverse( TreeNode node , int max , int [] count ) {
        if (node == null) return;
        if ( max <= node.val ) count[0]++;
        traverse(node.left, Math.max(max, node.val), count);
        traverse(node.right, Math.max(max, node.val), count);
    }

}
