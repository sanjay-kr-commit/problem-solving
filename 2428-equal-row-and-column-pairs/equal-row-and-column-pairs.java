import java.util.*;
class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> set = new HashMap<>();
        int count = 0 ;
        StringBuilder[] cols = new StringBuilder[ grid.length ] ;
        for ( int i = 0 ; i < grid.length ; i++ ) {
            cols[i] = new StringBuilder() ;
        }
        for ( int i = 0 ; i < grid.length ; i++ ) {
            StringBuilder row = new StringBuilder() ;
            for ( int j = 0 ; j < grid.length ; j++ ) {
                row.append( grid[i][j] ) ;
                row.append( "," ) ;
                cols[j].append( grid[i][j] ) ;
                cols[j].append( "," ) ;
            }
            if ( set.containsKey( row.toString() ) ) set.put( row.toString() , set.get( row.toString() ) + 1 ) ;
            else set.put( row.toString() , 1 ) ;
        }
        for ( int i = 0 ; i < grid.length ; i++ ) {
            Integer val = set.get( cols[i].toString() ) ;
            if ( val == null ) val = 0 ;
            count += val ;
        }
        return count ;
    }
}

