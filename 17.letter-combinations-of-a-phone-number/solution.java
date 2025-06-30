import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// @leet start

class Solution {

  Map<Integer, List<Character>> map;

  public Solution() {
    map = new HashMap<>();
    map.put(2, List.of('a', 'b', 'c'));
    map.put(3, List.of('d', 'e', 'f'));
    map.put(4, List.of('g', 'h', 'i'));
    map.put(5, List.of('j', 'k', 'l'));
    map.put(6, List.of('m', 'n', 'o'));
    map.put(7, List.of('p', 'q', 'r', 's'));
    map.put(8, List.of('t', 'u', 'v'));
    map.put(9, List.of('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {
    LinkedList<String> list = new LinkedList<>();
    backtrack(list, new StringBuilder(), digits, 0, digits.length());
    return list;
  }

  void backtrack(LinkedList<String> list, StringBuilder candidate, String digits, int index, int len) {
    if (index == len) {
      if (!candidate.isEmpty())
        list.add(candidate.toString());
      return;
    }
    for (char c : map.get(digits.charAt(index++) - '0')) {
      candidate.append(c);
      backtrack(list, candidate, digits, index, len);
      candidate.deleteCharAt(candidate.length() - 1);
    }
  }

}
// @leet end
