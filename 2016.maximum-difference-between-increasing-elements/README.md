// @leet start
class Solution {
  public int maximumDifference(int[] nums) {
    int dif = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j])
          continue;
        dif = Math.max(dif, nums[j] - nums[i]);
      }
    }
    return dif;
  }
}
// @leet end
