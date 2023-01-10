import java.util.Arrays;

class Solution {

    public int findContentChildren(int[] g, int[] s) {
      int satisfied = 0 ;
      Arrays.sort( g );
      Arrays.sort( s );
      int i = 0 , j = 0 , l1 = g.length , l2 = s.length ;
      while ( i < l1 && j < l2 ) {
        while( j < l2 && g[i] > s[j] ) j++ ;
        if ( j < l2 ) satisfied++ ;
        j++ ; i++ ;
      }
      return satisfied ;
    }
}
