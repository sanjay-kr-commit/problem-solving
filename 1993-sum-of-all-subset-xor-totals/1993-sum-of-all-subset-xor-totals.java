class Solution {
    public int subsetXORSum(int[] nums) {
        int[] ans = new int[]{0};
        helper(nums, 0, 0, ans);
        return ans[0];
    }

    private void helper(int[] nums, int cur, int sub, int[] ans) {
        if (cur == nums.length) {
            ans[0] += sub;
            return;
        }
        helper(nums, cur + 1, sub, ans);
        helper(nums, cur + 1, sub ^ nums[cur], ans);
    }
}