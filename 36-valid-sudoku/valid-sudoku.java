class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] gridCheck = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char key = board[i][j];
                if ( key == '.' ) continue;
                int num = key - '1';
                int gridIndex = (i / 3) * 3 + (j / 3);
                if (rowCheck[i][num] || colCheck[j][num] || gridCheck[gridIndex][num]) return false;
                rowCheck[i][num] = true;
                colCheck[j][num] = true;
                gridCheck[gridIndex][num] = true;
            }
        }
        return true;
    }
}