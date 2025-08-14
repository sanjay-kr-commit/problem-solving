// @leet start
class Solution {
  public String largestGoodInteger(String num) {
    int l = 0, len = num.length() - 2;
    int ll = 0, rl = 0, max = 0;
    while (l < len) {
      if (num.charAt(l) == num.charAt(l + 1) && num.charAt(l) == num.charAt(l + 2) && max < num.charAt(l)) {
        ll = l;
        rl = l + 3;
        max = num.charAt(l);
      }
      l++;
    }
    return num.substring(ll, rl);
  }
}
// @leet end
