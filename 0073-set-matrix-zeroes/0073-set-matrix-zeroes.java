class Solution {
  public void setZeroes(int[][] matrix) {
    // mark rows and cols which need to be zeroed out
    boolean [] array = new boolean[ matrix.length + matrix[0].length ] ;
    for ( int i = 0 ; i < matrix.length ; i++ ) {
      for ( int j = 0 ; j < matrix[0].length ; j++ ) {
        // mark rows
        array[i] = array[i] || matrix[i][j] == 0 ;
        // mark rows
        array[j+matrix.length] = array[j+matrix.length] || matrix[i][j] == 0 ;
      }
    }
    // filling rows as zero 
    for ( int i = 0 ; i < matrix.length ; i++ ) {
      if ( !array[i] ) continue ;
      for ( int j = 0 ; j < matrix[i].length ; j++ ) 
        matrix[i][j] = 0 ;
    }
    // filling cols as zero 
    for ( int i = matrix.length ; i < array.length ; i++ ) {
      if ( !array[i] ) continue ;
      int k = i - matrix.length ;
      for ( int j = 0 ; j < matrix.length ; j++ ) 
        matrix[j][k] = 0 ; 
    }
  }
}