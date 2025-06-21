// @leet start
class Solution {
  public int minSteps(int n) {
    int steps = steps(1, n, 0, 0);
    return steps;
  }

  int steps(int count, int n, int steps, int copied) {
    if (count == n)
      return steps;
    if (steps == n)
      return Integer.MAX_VALUE;
    int copy = (copied == 0 || (count > copied && (n - count) % count == 0)) ? steps(count, n, steps + 1, count)
        : Integer.MAX_VALUE;
    int paste = (copied == 0 || (n - count) % copied != 0) ? Integer.MAX_VALUE
        : steps(count + copied, n, steps + 1, copied);
    return Math.min(copy, paste);

  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().minSteps(
            29));
  }

}
// @leet end
