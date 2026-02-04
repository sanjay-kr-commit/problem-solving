int *dp = NULL ;
int t( int n ) {
    if ( dp[n] == -1 ) {
        dp[n] = t(n-1) + t(n-2) + t(n-3) ; 
    }
    return dp[n] ;
}
int tribonacci(int n) {
    if ( dp != NULL ) free(dp) ;
    dp = malloc(sizeof(int)*(n+3)) ;
    for ( int i = 0 ; i <= n ; i++ ) dp[i] = -1; 
    dp[0] = 0 ; dp[1] = 1 ; dp[2] = 1 ;
    return t(n) ;
}