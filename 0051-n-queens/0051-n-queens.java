import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
                                                                                                                                   
// @leet start
class Solution {
  public List<List<String>> solveNQueens(int n) {
    LinkedList<List<String>> list = new LinkedList<>();
    int [] row = new int[n] ;
    int [] col = new int[n] ;
    Arrays.fill(row,-1);
    Arrays.fill(col,-1);
    fillBoard( row , col , list , 0 ,n , 0 );
    return list ;
  }
                                                                                                                                   
  void fillBoard(int [] row , int[] col , LinkedList<List<String>> list, int queen , int n , int k) {
    if ( queen == n ) {

      LinkedList<String> candidate = new LinkedList<>();
      char [] chars = new char[ n ] ;
      for ( int i = 0 ; i < n ; i++ ) {
        int index = 0 ;
        for ( int j = 0 ; j < n ; j++ ) {
          chars[index++] = ( row[i] == j && col[j] == i ) ? 'Q' : '.' ;
        }
        candidate.add( new String(chars) );
      }
      list.add(candidate);
      return;
    }
    for ( int i = k ; i < n ; i++ ) {
      if ( row[i] != -1 ) continue;
      for ( int j = 0 ; j < n ; j++ ) {
        if ( col[j] != -1 ) continue;
        if ( diagonalCheck( row , col , i , j , +1 , +1 ) &&
                 diagonalCheck( row , col , i , j , -1 , -1 ) &&
                 diagonalCheck( row , col , i , j , +1 , -1 ) &&
                 diagonalCheck( row , col , i , j , -1 , +1 )
        ) {
          row[i] = j;
          col[j] = i;
          fillBoard(row, col, list, queen + 1, n , i+1);
          row[i] = -1;
          col[j] = -1;
        }
      }
    }
  }
                       
  boolean diagonalCheck( int [] row , int [] col , int i , int j , int x , int y ) {
    i += x ;
    j += y ;
    while ( i > -1 && i < row.length && j > -1 && j < col.length ) {
      if ( row[i] == j && col[j] == i ) return false ;
      i += x ;
      j += y ;
    }
    return true ;
  }
                                                                                                                                   
}
