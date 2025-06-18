// @leet start

import java.util.Arrays;

class Solution {
  public int[][] divideArray(int[] nums, int k) {
    if (nums.length % 3 != 0)
      return new int[][] {};
    int filled = 0;
    Arrays.sort(nums);
    int[][] res = new int[nums.length / 3][];
    for (int i = 0, len = nums.length - 2; i < len; i++) {
      int j = 0, max = nums[i] + k + 1;
      while (j < 3 && nums[j + i] < max)
        j++;
      if (j == 3) {
        res[filled++] = new int[] {
            nums[i], nums[i + 1], nums[i + 2]
        };
        i += 2;
      }
    }
    if (filled < nums.length / 3)
      return new int[][] {};
    return res;
  }

}
// @leet end
