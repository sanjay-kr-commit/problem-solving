import java.util.HashMap;
import java.util.Map;

class Solution {
    private int hashRow(int[] row){
        int hash=0;
        for (int n : row){
            hash = n+hash*5;
        }
        return hash;
    }
    private int hashCol(int[][] grid, int col){
        int hash=0;
        for (int[] ints : grid) {
            hash = ints[col] + hash * 5;
        }
        return hash;
    }
    public int equalPairs(int[][] grid) {
        int n = grid.length , count = 0;
        Map<Integer, Integer> rows = new HashMap<>();
        for ( int [] row : grid ) {
            int hashRow = hashRow(row);
            rows.put(hashRow, rows.getOrDefault(hashRow,0)+1);
        }
        for ( int i = 0 ; i < n ; i++ ) count += rows.getOrDefault(hashCol(grid,i),0);
        return count;
    }
}