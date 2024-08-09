class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int m = n , size = (n*n) + 1 , count = 1 , x = 0 , y = 1 ,
            offX = 0 , offY = 0 , i = 0 , j = 0 , direction = 0 ;
        while ( count < size ) {
            matrix[offX+i][offY+j] = count++ ;
            if ( i == 0 && j == n-1 && direction == 0 ) {
                direction++ ; x++ ; y-- ;
            } else if ( i == m-1 && j == n-1 && direction == 1 ) {
                direction++ ; x-- ; y-- ;
            } else if ( i == n-1 && j == 0 && direction == 2 ) {
                direction++ ; x-- ; y++ ;
            } else if ( i == 1 && j == 0 && direction == 3 ) {
                direction = 0 ; m -= 2 ; n -= 2 ; offX++ ; offY++ ;
                x++ ; y++ ; i = 0 ; j = 0 ; i -= x ; j -= y ;
            }
            i += x ; j += y ;
        }
        return matrix ;
    }
}