// 1ms
class Solution {
    public boolean isPowerOfTwo(int n) {
        if ( n < 1) return false ;
        int j = 0 ;
        for ( int i = 0 ; i < 31 ; i++ ) {
            if ( n <= j ) return false ;
            else if ( n == j+1 ) return true ;
            j = j << 1|1 ;
        }
        return false ;
    }
}

// 2ms
class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return ( (n & (n-1)) == 0 && n > 0 ) ;
    }
}