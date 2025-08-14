import java.util.HashMap;

// @leet start

class Solution {
  public int maxProfit(int[] prices) {
    HashMap<String, Integer> map = new HashMap<>();
    return maxProfit(prices, 0, true, map);
  }

  int maxProfit(int[] prices, int i, boolean buying, HashMap<String, Integer> map) {
    if (i >= prices.length)
      return 0;
    String key = i + "" + buying;
    if (map.containsKey(key))
      return map.get(key);
    int cooldown = maxProfit(prices, i + 1, buying, map);
    int burOrSell = maxProfit(prices, i + ((buying) ? 1 : 2), !buying, map) + ((buying) ? -prices[i] : prices[i]);
    map.put(key, Math.max(cooldown, burOrSell));
    return map.get(key);
  }

}
// @leet end
