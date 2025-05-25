// @leet start

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int longestPalindrome(String[] words) {
    HashMap<Long, Integer> map = new HashMap<>();
    int length = 0;
    for (String word : words) {

      long hash = hash(word), reverseHash = reverseHash(word);

      if (map.containsKey(hash) && map.get(hash) > 0) {
        length += 4;
        map.put(hash, map.get(hash) - 1);
      } else
        map.put(reverseHash, map.getOrDefault(reverseHash, 0) + 1);
    }

    for (Map.Entry<Long, Integer> key : map.entrySet()) {

      if (key.getValue() < 1 || !isTwin(key.getKey()))
        continue;

      length += 2;
      break;

    }

    return length;
  }

  boolean isTwin(long hash) {
    return ((int) hash) == ((int) (hash >> 32));
  }

  long hash(String word) {
    return ((1L << (word.charAt(0) - 'a')) | (1L << (word.charAt(1) - 'a' + 32)));
  }

  long reverseHash(String word) {
    return ((1L << (word.charAt(1) - 'a')) | (1L << (word.charAt(0) - 'a' + 32)));
  }

}
// @leet end
