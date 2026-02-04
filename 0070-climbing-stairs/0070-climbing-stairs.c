int *dp = NULL ;
int cs( int i , int n ) {
    if ( i == n ) return 1 ;
    if ( i > n ) return 0 ;
    if ( dp[i] == -1 ) {
        dp[i] = cs( i +1 , n ) + cs( i + 2 , n ) ;
    }
    return dp[i] ;
}
int climbStairs(int n) {
    if ( dp != NULL ) free(dp) ;
    dp = malloc(sizeof(int)*n) ;
    for ( int i = 0 ; i < n ; i++ ) dp[i] = -1 ;
    cs(0,n) ;
    return dp[0] ;
}