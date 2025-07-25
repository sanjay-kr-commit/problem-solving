import java.util.Arrays;

// @leet start
class Solution {
  // bellman ford algo
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] prices = new int[n];
    int[] temp = new int[n];
    Arrays.fill(prices, Integer.MAX_VALUE);
    prices[src] = 0;
    for (int j = -1; j < k; j++) {
      for (int i = 0; i < n; i++)
        temp[i] = prices[i];
      for (int[] flight : flights) {
        if (prices[flight[0]] == Integer.MAX_VALUE)
          continue;
        if (prices[flight[0]] + flight[2] < temp[flight[1]])
          temp[flight[1]] = prices[flight[0]] + flight[2];
      }
      for (int i = 0; i < n; i++)
        prices[i] = temp[i];
    }
    if (prices[dst] == Integer.MAX_VALUE)
      return -1;
    return prices[dst];
  }
}
// @leet end
