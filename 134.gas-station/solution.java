// @leet start
class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int sumGas = 0, sumCost = 0;
    for (int i = 0; i < gas.length; i++) {
      sumGas += gas[i];
      sumCost += cost[i];
    }
    if (sumGas < sumCost)
      return -1;
    int index = 0;
    for (int total = 0, i = 0; i < cost.length; i++) {
      total += (gas[i] - cost[i]);
      if (total < 0) {
        index = i + 1;
        total = 0;
      }
    }
    return index;
  }
}
// @leet end
