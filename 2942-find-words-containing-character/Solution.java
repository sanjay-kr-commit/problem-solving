// @leet start

import java.util.ArrayList;

class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    ArrayList<Integer> ans = new ArrayList<>(words.length);
    int index = 0;
    for (String str : words) {
      int hash = 1 << (x - 'a'), strHash = 0;
      for (int i = 0, size = str.length(); i < size; i++) {
        strHash |= 1 << (str.charAt(i) - 'a');
      }
      if ((strHash & hash) == hash)
        ans.add(index);
      index++;
    }
    return ans;
  }
}
// @leet end
