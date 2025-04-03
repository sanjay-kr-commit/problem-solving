class Solution {
  public int maxProfit(int[] prices) {
    int buyer = 0 , seller = 0 , max = 0 ;
    while ( seller < prices.length-1 ) {
      while ( buyer < seller && prices[buyer] >= prices[seller] ) buyer++ ;
      if ( prices[seller] >= prices[buyer] ) seller++ ;
      else buyer++ ;
      max = Math.max(max, prices[seller] - prices[buyer]);
    }
    return Math.max(max, prices[seller]-prices[buyer]);
  }
}
