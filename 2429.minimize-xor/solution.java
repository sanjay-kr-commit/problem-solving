// @leet start
class Solution {
  public int minimizeXor(int num1, int num2) {
    int bitCount = 0;
    for (int i = 0; i < 32; i++) {
      bitCount += num2 & 1;
      num2 >>>= 1;
    }
    int inverse = 0, bak = num1;
    for (int i = 0; i < 32; i++) {
      inverse <<= 1;
      inverse |= bak & 1;
      bak >>>= 1;
    }
    bak = inverse;
    inverse = 0;
    for (int i = 0; i < 32; i++) {
      inverse <<= 1;
      if (bitCount > 0 && (bak & 1) == 1) {
        inverse |= 1;
        bitCount--;
      }
      bak >>>= 1;
    }
    int i = 0, count = 0;
    bak = inverse;
    while (bitCount > 0) {
      if ((bak & 1) == 0) {
        i |= 1 << count;
        bitCount--;
      }
      count++;
      bak >>>= 1;
    }
    inverse |= i;
    return inverse;
  }
}
// @leet end
