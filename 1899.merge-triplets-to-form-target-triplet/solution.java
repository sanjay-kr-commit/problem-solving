// @leet start
class Solution {
  public boolean mergeTriplets(int[][] triplets, int[] target) {
    boolean[] usable = new boolean[triplets.length];
    for (int i = 0; i < triplets.length; i++) {
      if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
        usable[i] = false;
      } else
        usable[i] = true;
    }
    boolean a = false, b = false, c = false;
    for (int i = 0; i < usable.length; i++) {
      if (!usable[i])
        continue;
      a = a || triplets[i][0] == target[0];
      b = b || triplets[i][1] == target[1];
      c = c || triplets[i][2] == target[2];
    }
    return a && b && c;
  }
}
// @leet end
