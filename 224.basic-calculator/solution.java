// @leet start
class Solution {
  public int calculate(String s) {
    return calculate(s, 0, s.length(), new int[1]);
  }

  int calculate(String s, int index, int len, int[] skippedIndex) {
    int sum = 0;
    boolean add = true;
    int temp = 0;
    for (; index < len; index++) {
      char c = s.charAt(index);
      if (c == '(') {
        sum += ((add) ? 1 : -1) * calculate(s, index + 1, len, skippedIndex);
        index = skippedIndex[0];
        continue;
      } else if (c == ')') {
        skippedIndex[0] = index;
        sum += ((add) ? 1 : -1) * temp;
        return sum;
      } else if (c == '-' || c == '+') {
        sum += ((add) ? 1 : -1) * temp;
        add = c == '+';
        temp = 0;
        continue;
      } else if (c == ' ')
        continue;
      temp *= 10;
      temp += c - '0';
    }
    sum += ((add) ? 1 : -1) * temp;
    return sum;
  }
}
// @leet end
