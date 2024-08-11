class Solution {

    public int numIslands(char[][] grid) {
        int island = 0;
        int m = grid.length, n = grid[0].length;
        for ( int i = 0 ; i < grid.length ; i++ ) {
            for ( int j = 0 ; j < grid[0].length ; j++ ) {
                if ( grid[i][j] == '1' ) {
                    island++ ;
                    annihilateIsland( grid , i , j , m , n );
                }
            }
        }
        return island ;
    }

    void annihilateIsland( char[][] grid , int i , int j , int m , int n ) {
        grid[i][j] = '2' ;
        if ( i+1 < m && grid[i+1][j] == '1' ) annihilateIsland( grid , i+1 , j , m , n );
        if ( j > 0 && grid[i][j-1] == '1' ) annihilateIsland( grid , i , j-1 , m , n );
        if ( j+1 < n && grid[i][j+1] == '1' ) annihilateIsland( grid , i , j+1 , m , n );
        if ( i > 0 && grid[i-1][j] == '1' ) annihilateIsland( grid , i-1 , j , m , n );
    }

}