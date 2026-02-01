class Solution {
    public void setZeroes(int[][] matrix) {
        int [] rows = new int[ matrix.length ] ,
               cols = new int[ matrix[0].length ] ;
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                if ( matrix[i][j] != 0 ) continue ; 
                rows[i] = 1 ;
                cols[j] = 1 ;
            }
        }
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                if ( rows[i] != 1 && cols[j] != 1 ) continue ; 
                matrix[i][j] = 0 ;
            }
        }
    }
}