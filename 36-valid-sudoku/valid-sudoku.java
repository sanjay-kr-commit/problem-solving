import java.util.ArrayList;

class Solution {

    public boolean isValidSudoku(char[][] board) {

        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>(9) ;

        for ( int i = 0 ; i < 9 ; i++ ) coordinates.add( new ArrayList<>( 9 ) ) ;

        for ( int i = 0 ; i < 9 ; i++ ) {
            for ( int j = 0 ; j < 9 ; j++) {
                if ( board[i][j] == '.' ) continue;
                int index = board[i][j] - '1';
                int coordinateIndex = ((i+1)*10)+(j+1) ;
                coordinates.get( index ).add( coordinateIndex ) ;
            }
        }

        for ( int i = 0 ; i < 9 ; i++ ) {
            if ( coordinates.get( i ).size() < 2 ) continue;
            for ( int j = 0 ; j < coordinates.get( i ).size() ; j++ ) {
                int firstCoordinateIndex = coordinates.get( i ).get( j ) ;
                int x = (firstCoordinateIndex / 10) - 1 ;
                int y = (firstCoordinateIndex % 10) - 1 ;
                int rangeXS = (x / 3)*3 ;
                int rangeYS = (y / 3)*3 ;
                int rangeXE = rangeXS + 3 ;
                int rangeYE = rangeYS + 3 ;
                rangeXS-- ;
                rangeYS-- ;

                for ( int k = 0 ; k < coordinates.get( i ).size() ; k++ ) {

                    if ( firstCoordinateIndex == coordinates.get( i ).get( k ) ) continue;
                    int coordinateIndex = coordinates.get( i ).get( k ) ;
                    int localX = (coordinateIndex / 10)-1 ;
                    int localY = (coordinateIndex % 10)-1 ;
                    if ( x == localX || y == localY  ) return false ;
                    if ( localX > rangeXS && localX < rangeXE && localY > rangeYS && localY < rangeYE ) return false ;
                }

            }

        }

        return true ;
    }

}