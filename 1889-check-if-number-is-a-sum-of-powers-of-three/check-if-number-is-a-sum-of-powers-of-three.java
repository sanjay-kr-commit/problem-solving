class Solution {
    public boolean checkPowersOfThree(int n) {
        int count = 0 ;
        int used = 0 ;
        while ( count < n ) {
            int required = n - count ;
            int prev = 1 ;
            int localCount = 1 ;
            int power = 0 ;
            while ( localCount < required && power < 17 ) {
                prev = localCount ;
                localCount *= 3 ;
                power++ ;
            }
            if ( localCount <= required && ((used >> power) & 1 ) == 0 ) {
                count += localCount ;
                used |= 1 << power ;
                continue;
            }
            power-- ;
            if ( power > 0 && ((used >> power) & 1 ) == 0 ) {
                count += prev ;
                used |= 1 << power ;
                continue;
            }
            break;
        }
        return count == n ;
    }
}