class Solution {
    public boolean isPerfectSquare(int num) {
        if ( num == 1 ) return true ;
        int  lo = 1 , hi = num/2 ;
        while ( lo < hi ) {
            int mid = lo + ( hi - lo + 1 ) / 2 ;
            int t = num / mid ;
            if ( mid == t ) return (Math.log10(num) / Math.log10(mid)) % 1 == 0 ;
            else if ( t < mid ) hi = mid - 1;
            else  lo = mid ;
        }
        return false ;
    }
}