class Solution {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[ rows * cols ][2];
        int size = rows * cols ;
        int rEnd = rStart , cEnd = cStart ;
        int i = rStart , j = cStart , x = 0 , y = 1 , index = 0 ;
        while ( index < size ) {
            if ( i < rows && i > -1 && j < cols && j > -1 ) {
                result[index][0] = i ;
                result[index++][1] = j ;
            }
            if ( i == rStart && j == cEnd+1 ) {
                x++ ; y-- ;
            } else if ( j == cEnd+1 && i == rEnd+1  ) {
                x-- ; y-- ;
            } else if ( i == rEnd+1 && j == cStart-1  ) {
                x-- ; y++ ;
            } else if ( j == cStart-1 && i == rStart-1) {
                x++ ; y++ ;
            } else if ( i == rStart-1 && j == cEnd+1 ) {
               rStart-- ; cStart-- ; rEnd++ ; cEnd++ ;
            }
            i += x ; j += y ;
        }
        return result ;
    }

}