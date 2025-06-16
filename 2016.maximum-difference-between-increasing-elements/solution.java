// @leet start
class Solution {
  public int maximumDifference(int[] nums) {
    int dif = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        dif = Math.max(dif, nums[j] - nums[i]);
      }
    }
    return dif;
  }
}
// @leet end
