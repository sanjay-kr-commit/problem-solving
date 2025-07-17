// @leet start
class Solution {
  public int getSum(int a, int b) {
    if (a < 0 && b < 0)
      return -1 * getSum(a * -1, b * -1);
    if (a < 0)
      return getSum(b, a);

    if (b < 0)
      b = secondCompliment(-1 * b);
    return sum(a, b);
  }

  int sum(int a, int b) {
    int carry = 0;
    int x = 0;
    for (int i = 0; i < 32; i++) {
      int t = ((b >>> i) & 1) ^ ((a >>> i) & 1);
      int sum = t ^ carry;
      carry = (((a >>> i) & 1) & ((b >>> i) & 1)) | (t & carry);
      x |= sum << i;
    }
    return x;
  }

  int secondCompliment(int b) {
    int x = 0;
    for (int i = 0; i < 32; i++) {
      x |= ((((b >>> i) & 1) + 1) % 2) << i;
    }
    return x + 1;
  }

}
// @leet end
