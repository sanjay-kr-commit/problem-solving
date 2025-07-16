import java.util.LinkedList;
import java.util.List;

// @leet start
class Solution {
  public List<List<String>> partition(String s) {
    LinkedList<List<String>> list = new LinkedList<>();
    partition(s, 0, 0, s.length(), list, new LinkedList<>());
    return list;
  }

  void partition(String s, int start, int index, int len, LinkedList<List<String>> list, LinkedList<String> candidate) {
    if (index == len) {
      if (start == index)
        list.add(candidate);
      return;
    }
    if (isPalidrome(s, start, index)) {
      LinkedList<String> copy = new LinkedList<>(candidate);
      copy.addLast(s.substring(start, index + 1));
      partition(s, index + 1, index + 1, len, list, copy);
    }
    partition(s, start, index + 1, len, list, candidate);
  }

  boolean isPalidrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l++) != s.charAt(r--))
        return false;
    }
    return true;
  }

}
// @leet end
