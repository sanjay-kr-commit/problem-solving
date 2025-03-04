class Solution {
    public boolean checkPowersOfThree(int n) {
        int used = 0 ;
        int count = 0 ;
        while ( count < n ) {
            int required = n - count;
            int localCount = 1 , prev = 1 ;
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

            if ( power > 0 && prev <= required && ((used >> power-1) & 1 ) == 0 ) {
                count += prev ;
                used |= 1 << (power-1) ;
                continue;
            }

            if ( power < 17 && ((used >> power+1) & 1 ) == 0 ) {
                count += localCount*3 ;
                used |= 1 << (power+1) ;
                continue;
            }

            break;

        }
        return count == n ;
    }
}