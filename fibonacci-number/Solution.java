class Solution {
    public int fib(int n) {
        if ( n == 0 ) return 0 ;
        int first = 1 , second = 1 ;
        for ( int i = 1 ; i < n ; i++ ) {
            first += second ;
            second -= first ;
            second *= -1 ;
        }
        return second ;
    }
}
