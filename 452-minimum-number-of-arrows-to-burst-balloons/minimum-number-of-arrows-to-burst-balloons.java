import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else if (o1[0] > o2[0]) return 1;
                else return Integer.compare(o1[1], o2[1]);
            }
        }) ;
        int arrows = 1 , last = points[0][1];
        for ( int [] point : points ) {
            if ( point[0] > last ) {
                arrows++ ;
                last = point[1] ;
            }
            else last = Math.min( point[1] , last ) ;
        }
        return arrows ;
    }
}