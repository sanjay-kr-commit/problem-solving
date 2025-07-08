// @leet start
class Solution {

  public int climbStairs(int n) {
    return worked(n, new int[n + 1]);
  }

  int worked(int n, int[] map) {
    if (n == 0)
      return 1;
    if (n < 0)
      return 0;
    if (map[n] != 0)
      return map[n];
    map[n] = worked(n - 1, map) + worked(n - 2, map);
    return map[n];
  }

}
// @leet end
