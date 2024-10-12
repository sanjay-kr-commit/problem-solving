import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrowThrown = 0 ;
        Arrays.sort( points , (o1, o2) -> {
            if ( o1[0] == o2[0] ) {
                return Integer.compare(o1[1], o2[1]);
            } else if ( o1[0] < o2[0] ) return -1 ;
            else return 1 ;
        });
        int start = -1 , end = -1 ;
        for ( int [] point : points ) {
            if ( point[0] >= start && point[0] <= end ) {
                start = point[0] ;
                if ( point[1] < end ) end = point[1] ;
            } else {
                arrowThrown++ ;
                start = point[0] ;
                end = point[1] ;
            }
        }
        return arrowThrown;
    }
}