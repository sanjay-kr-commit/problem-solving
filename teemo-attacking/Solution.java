class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = ( timeSeries.length != 0 && timeSeries[0] == 0 ) ? 1 : 0 ;
        int initial = 0 , last = 0 ;
        for ( int i = 0 ; i < timeSeries.length ; i++ ) {
            if ( last < timeSeries[i] ) {
                total += last - initial ;
                initial = timeSeries[i] - 1 ;
            }
            last = timeSeries[i] + duration - 1;
        }
        total += last - initial ;
        return total;
    }
}
