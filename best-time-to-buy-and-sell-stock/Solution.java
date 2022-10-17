// 220 ms
class Solution1 {
    public int maxProfit(int[] prices) {
        int p = 0 , s = 0 , b = Integer.MAX_VALUE ;
        for ( int i = 0 ; i < prices.length ; i++ ) {
            if ( prices[i] < b ) {
                b = prices[i] ;
                s = b ;
                for ( int j = i+1 ; j < prices.length ; j++ ) {
                    if ( s < prices[j] ) s = prices[j] ;
                }
                if ( p < s-b ) p = s-b ;
            }
        }
        return p ;
    }
}

// 4 ms
class Solution2 {
    public int maxProfit(int[] prices) {
        int p = 0 , s = Integer.MAX_VALUE ;
        for ( int n : prices ) {
            if ( n < s ) s = n ;
            else if ( p < n-s ) p = n - s ; 
        }
        return p ;
    }
}

// 1ms
class Solution {
    public int maxProfit(int[] prices) {
        int p = 0 , s = Integer.MAX_VALUE ;
        for ( int n : prices ) {
            int tempP = n - s ;
            if ( n < s ) s = n ;
            else if ( tempP > p ) p = tempP ;
        }
        return p ;
    }
}