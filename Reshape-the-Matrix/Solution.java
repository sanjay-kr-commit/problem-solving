class Solution {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    if ( (c*r) != (mat.length * mat[0].length)  ) return mat ;
    int[][] reshapedMatrix = new int[r][c] ;
    int ir = 0 , ic = 0 ;
    for ( int[] row : mat ) {
      for ( int cell : row ) {
        if ( ic >= c ) {
          ic = 0 ;
          ir++ ;
        }
        reshapedMatrix[ir][ic++] = cell ;
      }
    }
    return reshapedMatrix ;
  }
}
