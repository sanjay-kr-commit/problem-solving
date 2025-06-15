// @leet start

import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public int[] recoverArray(int[] nums) {
    if (nums.length == 0)
      return nums;
    Arrays.sort(nums);
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums)
      map.put(num, map.getOrDefault(num, 0) + 1);
    int[] res = new int[nums.length / 2];
    for (int i = 0, len = nums.length; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[i] == nums[j] || (nums[j] - nums[i]) % 2 == 1)
          continue;
        if (isK((HashMap<Integer, Integer>) map.clone(), nums, res, (nums[j] - nums[i])))
          return res;
      }
    }
    return res;
  }

  boolean isK(HashMap<Integer, Integer> used, int[] nums, int[] res, int k) {
    int i = 0;
    int sub = k / 2;
    for (int num : nums) {
      if (used.get(num) == 0)
        continue;

      if (used.getOrDefault(num - k, 0) > 0) {
        res[i++] = num - sub;
        used.put(num, used.get(num) - 1);
        used.put(num - k, used.get(num - k) - 1);
      } else if (used.getOrDefault(num + k, 0) > 0) {
        res[i++] = num + sub;
        used.put(num, used.get(num) - 1);
        used.put(num + k, used.get(num + k) - 1);
      } else {
        return false;
      }
    }
    return true;
  }
}
// @leet end
