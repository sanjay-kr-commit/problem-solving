// @leet start
class Solution {
  public int lengthOfLIS(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++)
      max = Math.max(max, max(nums, i, nums.length)+1);
    return max;
  }

  int max(int[] nums, int index, int len) {
    if (index >= len)
      return 0;
    int max = 0;
    for (int i = index + 1; i < len; i++) {
      if (nums[index] < nums[i])
        max = Math.max(max, max(nums, i, len)+1);
    }
    return max;
  }
}
// @leet end
class m {
  public static void main(String[] args) {
    var s = new Solution();
    System.out.println(s.lengthOfLIS( new int[] {10,9,2,5,3,7,101,18} ));
  }
}