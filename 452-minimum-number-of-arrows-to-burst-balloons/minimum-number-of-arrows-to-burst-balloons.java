import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        final int n = points.length;
        final long[] merged = new long[n];
        for (int i = 0; i < n; i++) merged[i] = (((long)points[i][1]) << 32) | (points[i][0] & 0xFFFFFFFFL);
        Arrays.sort(merged);
        int prev = ( int )( merged[0] >>> 32 );
        int count = 1;
        for( int i = 1 ; i < merged.length ; i++ ) if ( (int) merged[i] > prev ) {
            count++;
            prev = (int)(merged[i] >>> 32);
        }

        return count;

    }
}