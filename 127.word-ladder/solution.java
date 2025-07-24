import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// @leet start
class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord))
      return 0;
    wordList = new LinkedList<>(wordList);
    wordList.add(beginWord);
    HashMap<String, HashSet<String>> map = new HashMap<>();
    for (String word : wordList) {
      for (int i = 0, len = word.length(); i < len; i++) {
        String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
        HashSet<String> set = map.getOrDefault(pattern, new HashSet<>());
        set.add(word);
        map.put(pattern, set);
      }
    }
    int res = 1;
    HashSet<String> visited = new HashSet<>();
    Stack<String> st = new Stack<>();
    st.add(beginWord);
    while (!st.isEmpty()) {
      Stack<String> ns = new Stack<>();
      for (int j = 0, len = st.size(); j < len; j++) {
        String pop = st.pop();
        if (pop.equals(endWord))
          return res;
        if (visited.contains(pop))
          continue;
        visited.add(pop);
        for (int i = 0, size = pop.length(); i < size; i++) {
          String pattern = pop.substring(0, i) + "*" + pop.substring(i + 1);
          for (String s : map.get(pattern)) {
            if (visited.contains(s))
              continue;
            ns.add(s);
          }
        }
      }
      st = ns;
      res++;
    }
    return 0;
  }
}
// @leet end
