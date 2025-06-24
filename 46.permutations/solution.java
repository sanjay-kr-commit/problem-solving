import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// @leet start
class Solution {
  public List<List<Integer>> permute(int[] nums) {
    LinkedList<List<Integer>> list = new LinkedList<>();
    backtrack(nums, list, new LinkedList<>(), 0, nums.length, new HashSet<Integer>());
    return list;
  }

  void backtrack(int[] nums, LinkedList<List<Integer>> list, LinkedList<Integer> permutation, int filled, int size,
      HashSet<Integer> hash) {
    if (filled == size) {
      LinkedList<Integer> ans = new LinkedList<>();
      for (int i : permutation)
        ans.add(nums[i]);
      list.add(ans);
      return;
    }
    for (int i = 0; i < size; i++) {
      if (hash.contains(i))
        continue;
      hash.add(i);
      permutation.add(i);
      backtrack(nums, list, permutation, filled + 1, size, hash);
      permutation.remove(permutation.size() - 1);
      hash.remove(i);
    }
  }

}
// @leet end
