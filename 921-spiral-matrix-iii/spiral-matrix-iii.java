class Solution {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> resultList = new ArrayList<>( rows * cols + 1 );
        int size = rows * cols ;
        int rEnd = rStart , cEnd = cStart ;
        int i = rStart , j = cStart , x = 0 , y = 1 ;
        while ( resultList.size() < size ) {
            if ( i < rows && i > -1 && j < cols && j > -1 ) {
                resultList.add( new int[]{ i , j } );
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
        int [][] result = new int[resultList.size()][2];
        for ( int k = 0 ; k < resultList.size() ; k++ ) result[k] = resultList.get(k) ;
        return result ;
    }

}