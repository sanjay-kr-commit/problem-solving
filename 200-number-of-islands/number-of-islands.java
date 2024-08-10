class Solution {

    int island ;

    public int numIslands(char[][] grid) {
        island = 0;
        for ( int i = 0 ; i < grid.length ; i++ ) {
            for ( int j = 0 ; j < grid[0].length ; j++ ) {
                if ( grid[i][j] == '1' ) {
                    island++ ;
                    annihilateIsland( grid , i , j );
                }
            }
        }
        return island ;
    }

    void annihilateIsland( char[][] grid , int i , int j ) {
        if ( i < 0 || i >= grid.length || j >= grid[i].length || j < 0 || grid[i][j] == '0'  ) return;
        grid[i][j] = '0' ;
        annihilateIsland( grid , i+1 , j );
        annihilateIsland( grid , i , j-1 );
        annihilateIsland( grid , i , j+1 );
        annihilateIsland( grid , i-1 , j );
    }

}