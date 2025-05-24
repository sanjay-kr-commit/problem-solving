// @leet start

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    ArrayList<Integer> ans = new ArrayList<>();
    int index = 0;
    for (String str : words) {
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == x) {
          ans.add(index);
          break;
        }
      }
      index++;
    }
    return ans;
  }
}
// @leet end
