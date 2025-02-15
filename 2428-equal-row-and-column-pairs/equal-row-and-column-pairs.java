import java.util.*;
class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> set = new HashMap<>();
        int count = 0 ;
        for ( int[] row : grid ) {
            StringBuilder builder = new StringBuilder();
            for ( int col : row ) {
                builder.append( col );
                builder.append( "," );
            }
            set.put( builder.toString(), set.getOrDefault( builder.toString(), 0) + 1 );
        }
        for ( int i = 0 ; i < grid.length ; i++ ) {
            StringBuilder builder = new StringBuilder();
            for ( int j = 0 ; j < grid.length ; j++ ) {
                builder.append( grid[j][i] ) ;
                builder.append( "," );
            }
            count += set.getOrDefault( builder.toString(), 0 );
        }
        return count ;
    }
}

