class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        long sum = 0;
        for( int pile : piles )
            sum += pile;
        int low = (int) mathCeilDiv(sum, h);
        int hi = (int) mathCeilDiv(sum - piles.length + 1, h - piles.length + 1);

        int mid;
        while (low < hi) {
            mid = low + (hi - low) / 2;
            int count = 0;
            for ( int pile : piles ) {
                count += (int) mathCeilDiv(pile, mid);
                if (count > h) break;
            }
            if (count <= h) hi=mid;
            else low = mid + 1;
        }
        return hi;
    }

    private long mathCeilDiv(long x, long y) {
        return ( x + y - 1 ) / y ;
    }
}