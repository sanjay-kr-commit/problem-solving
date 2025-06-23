import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @leet start
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    ArrayList<List<Integer>> ans = new ArrayList<>();
    int r = candidates.length - 1;
    while (r > -1 && candidates[r] > target)
      r--;

    while (r > -1) {
      sum(candidates, r, target, candidates[r], ans, new ArrayList<>(List.of(candidates[r])));
      r--;
    }
    for (int i = 0, size = ans.size(), len = size / 2; i < len; i++) {
      List<Integer> temp = ans.get(i);
      ans.set(i, ans.get(size - i - 1));
      ans.set(size - i - 1, temp);
    }
    return ans;
  }

  boolean sum(int[] candidates, int r, int target, int sum, ArrayList<List<Integer>> ans,
      ArrayList<Integer> candidate) {
    if (sum > target)
      return false;
    if (sum == target) {
      for (int i = 0, size = candidate.size(), len = size / 2; i < len; i++) {
        int temp = candidate.get(i);
        candidate.set(i, candidate.get(size - i - 1));
        candidate.set(size - i - 1, temp);
      }
      ans.add(candidate);
      return true;
    }
    while (r > -1) {
      ArrayList<Integer> temp = new ArrayList<>(candidate);
      temp.add(candidates[r]);
      sum(candidates, r, target, sum + candidates[r], ans, temp);
      r--;
    }
    return false;
  }

}
// @leet end
