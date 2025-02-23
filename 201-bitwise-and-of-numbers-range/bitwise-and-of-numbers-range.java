class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = right - left ;
        int newNum = 0 , power = 1 ;
        for ( int i = 0 ; i < 32 ; i++ ) {
            if ( (right & 1) == 1 && (left & 1) == 1 && diff < power ) {
                newNum = (newNum) | (1 << i) ;
            }
            right = right >> 1 ;
            left = left >> 1 ;
            power <<= 1 ;
        }
        return newNum ;
    }
}