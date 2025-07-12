// @leet start

class Solution {
  public int maxProduct(int[] nums) {
    int max = nums[0];
    int lpro = 1, rpro = 1;
    for (int i = 0, j = nums.length - 1; j > -1; j--, i++) {
      lpro *= nums[i];
      rpro *= nums[j];
      max = Math.max(max, Math.max(lpro, rpro));
      if (lpro == 0)
        lpro = 1;
      if (rpro == 0)
        rpro = 1;
    }
    return max;
  }
}
// @leet end
