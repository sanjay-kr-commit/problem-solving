// @leet start
class Solution {
  public String longestPalindrome(String s) {
    if (s.length() < 2)
      return s;
    int l = 0, r = 0, max = 0;
    int[] pr = new int[2];
    for (int i = 0, len = s.length(); i < len; i++) {
      if (isExpandable(s, len, i, i, max, pr) && pr[1] - pr[0] > max) {
        max = pr[1] - pr[0];
        l = pr[0];
        r = pr[1];
      }
      if (isExpandable(s, len, i - 1, i, max, pr) && pr[1] - pr[0] > max) {
        max = pr[1] - pr[0];
        l = pr[0];
        r = pr[1];
      }
    }
    return s.substring(l, r);
  }

  boolean isExpandable(String s, int len, int l, int r, int max, int[] pr) {
    if (l < 0)
      return false;
    int expansion = Math.max(l, len - r);
    if (expansion < max / 2)
      return false;
    while (l > -1 && r < len && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    pr[0] = ++l;
    pr[1] = r;
    return true;
  }
}
// @leet end
