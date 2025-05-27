// @leet start
class Solution {
  public int differenceOfSums(int n, int m) {
    int sumD = 0, sumND = 0;
    n++;
    for (int i = 1; i < n; i++) {
      if (i % m == 0)
        sumD += i;
      else
        sumND += i;
    }
    return sumND - sumD;
  }
}
// @leet end
