import java.util.ArrayList;
import java.util.List;

// @leet start
class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    sum(ans, n, k, 0, 9, new ArrayList<Integer>());
    return ans;
  }

  void sum(ArrayList<List<Integer>> ans, int target, int k, int sum, int n, ArrayList<Integer> candidate) {
    if (sum == target && k == 0) {
      ans.add(candidate);
      return;
    }
    if (n == 0 || k == 0)
      return;
    ArrayList<Integer> temp = new ArrayList<>(candidate);
    temp.add(n);
    n--;
    sum(ans, target, k - 1, sum + n + 1, n, temp);
    sum(ans, target, k, sum, n, candidate);
  }
}
// @leet end
