import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        final int n = points.length;
        final long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = (((long)points[i][1]) << 32) | (points[i][0] & 0xFFFFFFFFL);
        }
        Arrays.sort(A);
        int prev = (int)(A[0] >>> 32);
        int count = 1;
        for(int i=1; i< A.length; i++){
            if((int)A[i] > prev){
                count++;
                prev = (int)(A[i] >>> 32);
            }
        }
        return count;
    }
}