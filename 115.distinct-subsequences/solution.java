import java.util.HashMap;

// @leet start

class Solution {
  public int numDistinct(String s, String t) {
    HashMap<Integer, Integer> cache = new HashMap<>();
    return dfs(cache, 0, 0, s, t, s.length(), t.length());
  }

  int dfs(HashMap<Integer, Integer> cache, int i, int j, String s, String t, int n, int m) {
    if (j == m)
      return 1;
    if (i == n)
      return 0;
    int k = (i << 16) | j;
    if (cache.containsKey(k))
      return cache.get(k);
    int res = dfs(cache, i + 1, j, s, t, n, m);
    if (s.charAt(i) == t.charAt(j)) {
      res += dfs(cache, i + 1, j + 1, s, t, n, m);
    }
    cache.put(k, res);
    return res;
  }

}
// @leet end
