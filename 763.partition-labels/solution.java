import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// @leet start
class Solution {
  public List<Integer> partitionLabels(String s) {
    LinkedList<Integer> list = new LinkedList<>();
    int[] freq = new int[26];
    for (int i = 0, len = s.length(); i < len; i++)
      freq[s.charAt(i) - 'a']++;
    int l = 0, r = 0, len = s.length();
    boolean[] set = new boolean[26];
    while (r < len) {
      int index = s.charAt(r++) - 'a';
      freq[index]--;
      set[index] = true;
      int count = 0;
      for (int i = 0; i < 26; i++) {
        if (set[i])
          count += freq[i];
      }
      if (count == 0) {
        list.add(r - l);
        l = r;
        Arrays.fill(set, false);
      }
    }
    return list;
  }
}
// @leet end
