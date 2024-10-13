import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort( intervals , ( a , b ) -> {
            if ( a[0] == b[0] ) return Integer.compare(a[1], b[1]);
            else if ( a[0] < b[0] ) return -1;
            return 1 ;
        } );
        int overlaps = 0;
        for ( int i = 1 , j = 0 , end = intervals[j][1] , len = intervals.length ; i < len ; i++ ) {
            if ( intervals[i][0] == intervals[j][0] ) {
                overlaps++ ;
                continue;
            }
            if (  intervals[i][0] < end ) {
                end = Math.min( intervals[i][1] , end );
                overlaps++ ;
            } else end = Math.max( intervals[i][1] , end );
            j = i ;
        }
        return overlaps;
    }
}