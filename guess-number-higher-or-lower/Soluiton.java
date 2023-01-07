public class Solution extends GuessGame {
    
    public int guessNumber(int n) {
      int l = 1 , h = n , m = -1 ;
      while ( guess(m) != 0 ) {
        m = l + ( h - l ) / 2 ;
        switch ( guess(m) ) {
          case 1:
          l = m+1 ;
          break;
          default :
          h = m-1;
          break ;
        }
      }
      return m ;
    }

}
