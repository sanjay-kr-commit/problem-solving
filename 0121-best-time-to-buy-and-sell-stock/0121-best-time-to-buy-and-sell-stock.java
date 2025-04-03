class Solution {
  public int maxProfit(int[] prices) {
    int profit = 0 ,
        stockPrice = Integer.MAX_VALUE ,
        temporaryStockPrice ;
    for ( int n : prices ) {
      temporaryStockPrice = n - stockPrice ;
      if ( n < stockPrice ) stockPrice = n ;
      else if ( temporaryStockPrice > profit ) profit = temporaryStockPrice ;
    }
    return profit ;
  }
}
