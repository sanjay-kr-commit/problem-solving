class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = right - left ;
        int newNum = 0 , power = 1 ;
        for ( int i = 0 ; i < 32 ; i++ ) {
            if ( diff < power && ((right >> i) & 1) == 1 && ((left>>i) & 1) == 1 ) {
                newNum = (newNum) | (1 << i) ;
            }
            power <<= 1 ;
        }
        return newNum ;
    }
}