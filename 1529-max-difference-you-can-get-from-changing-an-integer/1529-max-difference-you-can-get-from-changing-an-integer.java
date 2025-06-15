
import java.util.HashSet;

class Solution {
  public int maxDiff(int num) {
    long rev = 1;
    while (num > 0) {
      rev *= 10;
      rev += num % 10;
      num /= 10;
    }
    int min_r = -1, max_r = -1, max = 0, min = 0, mod, step = 0, reminder = -1;
    HashSet<Integer> skipped = new HashSet<Integer>();
    while (rev > 1) {
      mod = (int) (rev % 10);
      if (max_r == -1 && mod != 9)
        max_r = mod;
      if (min_r == -1 && !skipped.contains(mod) && ((step == 0 && mod != 1) || (step != 0 && mod != 0))) {
        min_r = mod;
        reminder = step;
      } else
        skipped.add(mod);
      min *= 10;
      min += (min_r == mod) ? ((reminder == 0) ? 1 : 0) : mod;
      max *= 10;
      max += (max_r == mod) ? 9 : mod;
      rev /= 10;
      step++;
    }
    return max - min;
  }
}