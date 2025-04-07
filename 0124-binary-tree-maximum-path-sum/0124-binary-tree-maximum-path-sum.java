class Solution {
    int ans = -20000;
    public int maxPathSum2(TreeNode root) {
        if( root == null ) return -20000;
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        ans = Math.max(ans, Math.max(left+root.val+right,Math.max(root.val,Math.max(left+root.val,right+root.val))));
        return Math.max(root.val,Math.max(left+root.val,right+root.val));
    }
    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return ans;
    }
}