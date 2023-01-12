class Solution {
    public int islandPerimeter(int[][] grid) {
      if ( grid == null || grid.length == 0 ) return 0 ;
       int perimeter = 0 , col = grid.length , row = grid[0].length ;
       for ( int i = 0 ; i < grid.length ; i++ ) {
         for ( int j = 0 ; j < grid[i].length ; j++ ) {
           if ( grid[i][j] == 0 ) continue ;
           if ( i == 0 ) perimeter++ ;
           if ( i == grid.length-1 ) perimeter++ ;
           if ( i > 0 && grid[i-1][j] == 0 ) perimeter++ ;
           if ( i < grid.length-1 && grid[i+1][j] == 0 ) perimeter++ ;
           if ( j == 0 ) perimeter++ ;
           if ( j == grid[i].length-1 ) perimeter++ ;
           if ( j > 0 && grid[i][j-1] == 0 ) perimeter++ ;
           if ( j < grid[i].length-1 && grid[i][j+1] == 0 ) perimeter++ ;
         }
       }
       return perimeter ;
    }
}
