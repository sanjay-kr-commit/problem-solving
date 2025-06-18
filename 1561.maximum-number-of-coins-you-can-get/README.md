// @leet start

import java.util.Arrays;

class Solution {
  public int maxCoins(int[] piles) {
    int collection = 0;
    Arrays.sort(piles);
    for (int i = 0, j = piles.length - 2, len = piles.length / 3; i < len; i++, j -= 2) {
      collection += piles[j];
    }
    return collection;
  }
}
// @leet end
