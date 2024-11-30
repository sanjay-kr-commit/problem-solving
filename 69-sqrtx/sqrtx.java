class Solution {
    public int mySqrt(int x) {
        if ( x <= 1 ) return x ;
        int l = 0 , r = x/2 , m , t ;
        while ( l < r ) {
            m = (r-l+1)/2 + l ;
            t = x / m ;
            if ( m == t ) return m ;
            else if ( t > m ) l = m ;
            else r = m-1 ;
        }
        return r ;
    }
}