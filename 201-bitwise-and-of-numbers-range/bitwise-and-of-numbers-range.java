class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = right - left ;
        int newNum = 0 , power = 1 ;
        for ( int i = 0 ; i < 32 ; i++ ) {
            if ( (right & 1) == 1 && (left & 1) == 1 && diff < power ) {
                newNum = (newNum << 1) | 1 ;
            } else newNum = newNum << 1 ;
            right = right >> 1 ;
            left = left >> 1 ;
            power *= 2 ;
        }
        int res = 0 ;
        for ( int i = 0 ; i < 32 ; i++ ) {
            res = ( res << 1 ) | ( newNum & 1 ) ;
            newNum >>= 1 ;
        }
        return res ;
    }
}