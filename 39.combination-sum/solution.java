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
    return ans;
  }

  boolean sum(int[] candidates, int r, int target, int sum, ArrayList<List<Integer>> ans,
      ArrayList<Integer> candidate) {
    if (sum > target)
      return false;
    if (sum == target) {
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
