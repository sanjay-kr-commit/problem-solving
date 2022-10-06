// i have no idea how this code works 
// took 3 ms
class Solution {
    public int mySqrt( int x ) {
        if ( x <= 1 ) return x ;
        int  lo = 1 , hi = x/2 ;
        while ( lo < hi ) {
            int mid = lo + ( hi - lo + 1 ) / 2 ;
            int t = x / mid ;
            if ( mid == t ) return mid ;
            else if ( t < mid ) hi = mid - 1;
            else  lo = mid ;
        }
        return hi ;
    }
}