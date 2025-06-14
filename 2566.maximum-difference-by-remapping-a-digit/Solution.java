// @leet start
class Solution {
  public int minMaxDifference(int num) {
    long rev = 1;
    while (num > 0) {
      rev *= 10;
      rev += num % 10;
      num /= 10;
    }
    int min_r = -1, max_r = -1, max = 0, min = 0, mod;
    while (rev > 1) {
      mod = (int) (rev % 10);
      if (max_r == -1 && mod != 9)
        max_r = mod;
      if (min_r == -1 && mod != 0)
        min_r = mod;
      min *= 10;
      min += (min_r == mod) ? 0 : mod;
      max *= 10;
      max += (max_r == mod) ? 9 : mod;
      rev /= 10;
    }
    return max - min;
  }
}
// @leet end
