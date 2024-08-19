class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int nearest = -1 , diff = Integer.MAX_VALUE , i = 0;
        for ( int[] point : points ) {
            if ( point[0] == x || point[1] == y ) {
                int localDiff = point[0]-x + point[1]-y ;
                if ( localDiff < 0 ) localDiff *= -1 ;
                if ( localDiff < diff ) {
                    diff = localDiff ;
                    nearest = i ;
                }
            }
            i++ ;
        }
        return nearest ;
    }
}