class Solution {
    public int[] finalPrices(int[] prices) {
        int [] result = new int[prices.length];
        for ( int j , i = 0 ; i < prices.length ; i++ ) {
            for ( j = i+1 ; j < prices.length && prices[j] > prices[i]  ; j++ ) ;
            result[i] = prices[i] - (( j == prices.length ) ? 0 : prices[j]) ;
        }
        return result ;
    }
}