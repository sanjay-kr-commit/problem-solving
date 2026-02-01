class Solution {
    int get( int [][] m , int i ) {
        return m[ i/m[0].length ][ i % m[0].length ] ;
    }

    int search( int x , int [][] m ) {
        int l = 0 , r = m.length * m[0].length -1;
        while ( l <= r ) {
            int mi  = l + ( r -l ) / 2 ;
            if ( get(m,mi) == x ) return mi ;
            else if ( get(m,mi) > x ) r = mi-1;
            else l = mi +1 ;
        }
        return -1 ;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        return search( target , matrix ) != -1  ;
    }
}