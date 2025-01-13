class Solution {
    int [] dp ;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        for ( int i = 0 ; i < cost.length ; i++ ) dp[i] = Integer.MIN_VALUE;
        return Math.min(
                minCostClimbingStairs( cost , 0 , cost.length ) ,
                minCostClimbingStairs( cost , 1 , cost.length )
        );
    }

    int minCostClimbingStairs(int[] cost , int i , int n) {
        if ( i >= n ) return 0 ;
        if ( dp[i] != Integer.MIN_VALUE ) return dp[i];
        dp[i] = cost[i] + Math.min(
                minCostClimbingStairs( cost , i+1 , cost.length ) ,
                minCostClimbingStairs( cost , i+2 , cost.length )
        ) ;
        return dp[i];
    }
}