// @leet start
class Solution {
  public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0, l, r, len = s.length(); i < len; i++) {
      l = i;
      r = i;
      while (l > -1 && r < len && s.charAt(l) == s.charAt(r)) {
        count++;
        l--;
        r++;
      }
      l = i - 1;
      r = i;
      while (l > -1 && r < len && s.charAt(l) == s.charAt(r)) {
        count++;
        l--;
        r++;
      }
    }
    return count;
  }
}
// @leet end
