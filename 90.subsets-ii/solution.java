// @leet start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, nums, 0, new ArrayList<>());
    return list;
  }

  public void backtrack(List<List<Integer>> list, int[] nums, int pos, List<Integer> tempList) {
    if (pos <= nums.length) {
      list.add(new ArrayList<>(tempList));
    }

    for (int i = pos; i < nums.length; i++) {
      if (i > pos && nums[i] == nums[i - 1]) {
        continue;
      }
      tempList.add(nums[i]);
      backtrack(list, nums, i + 1, tempList);
      tempList.remove(tempList.size() - 1);
    }
  }
}
// @leet end
