class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9] ,
                    cols = new boolean[9][9] ,
                    grid = new boolean[9][9] ;
        for ( int i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++ ) {
                if ( board[i][j] == '.' ) continue;
                int value = board[i][j] - '1';
                int gridIndex = (i/3) * 3 + (j/3) ;
                if ( rows[i][value] || cols[j][value] || grid[gridIndex][value] ) return false ;
                rows[i][value] = true;
                cols[j][value] = true;
                grid[gridIndex][value] = true;
            }
        }
        return true ;
    }
}