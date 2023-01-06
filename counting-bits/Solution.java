class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1] ;
        for ( int i = 0 ; i <= n ; i++ ) {
            int bit = 0 ;
            int t = i ;
            while ( t != 0 ) {
                bit += t&1 ;
                t = t>>1 ;
            }
            arr[i] = bit ;
        }   
        return arr ;    
    }
}
