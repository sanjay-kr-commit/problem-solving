class Solution {
    public int[] countBits(int n) {
        n++ ;
        int[] result = new int[n];
        for ( int i = 1 ; i < n ; i++ ) result[i] = countBit( i ) ; 
        return result ;
    }
    private int countBit( int n ) {
        int bitCount = 0;
        while ( n > 0 ) {
            bitCount += n & 1 ;
            n >>= 1 ;
        }
        return bitCount ;
    }
}