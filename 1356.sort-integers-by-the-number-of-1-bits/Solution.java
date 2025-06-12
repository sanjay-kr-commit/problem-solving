// @leet start

import java.util.Arrays;

class Solution {
  public int[] sortByBits(int[] arr) {
    int[][] bitCount = new int[arr.length][2];
    for (int i = 0; i < arr.length; i++) {
      bitCount[i] = new int[] { arr[i], bitCount(arr[i]) };
    }
    Arrays.sort(bitCount, (a, b) -> {
      int res = Integer.compare(a[1], b[1]);
      if (res != 0)
        return res;
      return Integer.compare(a[0], b[0]);
    });
    for (int i = 0; i < arr.length; i++) {
      arr[i] = bitCount[i][0];
    }
    return arr;
  }

  int bitCount(int a) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += a & 1;
      a >>>= 1;
    }
    return count;
  }
}
// @leet end
