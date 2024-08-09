class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length ,
            n = matrix[0].length ;
        List<Integer> result = new ArrayList<>( m * n + 1 );
        int i = 0 , j = 0 , offX = 0 , offY = 0 , x = 0 , y = 1 , size = m * n , direction = 0 ;
        while ( size-- > 0 ) {
            result.add( matrix[offX+i][offY+j] ) ;
            if ( i == 0 && j == n - 1 && direction == 0 ) {
                direction++ ;
                x++ ; y-- ;
            } else if ( i == m-1 && j == n-1 && direction == 1 ) {
                direction++ ;
                x-- ; y-- ;
            } else if ( i == m-1 && j == 0 && direction == 2 ) {
                direction++ ;
                x-- ; y++ ;
            } else if ( i == 1 && j == 0 && direction == 3 ) {
                direction = 0 ;
                m -= 2 ; n -= 2 ;
                offX++ ; offY++ ;
                x = 0 ; y = 1 ;
                i -= x+1 ;
                j -= y ;
            }
            i += x ;
            j += y ;
        }
        return result ;
    }
}