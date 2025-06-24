import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// @leet start
class Solution {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    Arrays.sort(candidates);
    backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
    return list;
  }

  private void backtrack(
      List<List<Integer>> answer,
      List<Integer> tempList,
      int[] candidates,
      int totalLeft,
      int index) {
    if (totalLeft < 0)
      return;
    else if (totalLeft == 0)
      answer.add(new ArrayList<>(tempList));
    else {
      for (int i = index; i < candidates.length && totalLeft >= candidates[i]; i++) {
        if (i > index && candidates[i] == candidates[i - 1])
          continue;
        tempList.add(candidates[i]);
        backtrack(
            answer,
            tempList,
            candidates,
            totalLeft - candidates[i],
            i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
// @leet end

class remp {
  public static void main(String[] args) {
    System.out.println(
        new Solution().combinationSum2(
            new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 33, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 44, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 49, 5, 5, 5, 5, 6, 6, 6, 6 },
            29));
    System.out.println(
        new Solution().combinationSum2(
            new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            27

        ));
  }
}
