class Solution {
    public int[] closestPrimes(int left, int right) {
        right++ ;
        boolean [] isPrime = new boolean[ right ] ;
        for ( int i = 0 ; i < right ; i++ ) isPrime[ i ] = true;
        int distance = Integer.MAX_VALUE ,
                first = -1 ,
                second = -1 ;
        for ( int i = 2 , last = -1 ; i < right ; i++ ) {
            if ( !isPrime[i] ) continue;
            if ( last >= left && ( distance == Integer.MAX_VALUE || (i-last) < distance ) ) {
                first = last ;
                second = i ;
                distance = i - last ;
            }
            last = i ;
            int sq = i*i ;
            sq-- ;
            for ( int j = i+i ; j < right ; j += i ) {
                if ( j > sq ) isPrime[j] = false;
            }
        }
        if ( first < left ) return new int[] { -1 , -1 } ;
        return new int[] { first, second };
    }

}