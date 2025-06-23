// @leet start
class Solution {
  public int reverse(int x) {
    boolean negative = x < 0;
    x = Math.abs(x);
    int rev = 0;
    int bound = Integer.MAX_VALUE / 10;
    while (x > 0) {
      if (rev > bound)
        return 0;
      if (rev == bound && x % 10 > 6)
        return 0;
      rev *= 10;
      rev += x % 10;
      x /= 10;
    }
    if (negative)
      rev *= -1;
    return rev;
  }
}
// @leet end
