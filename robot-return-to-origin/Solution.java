// 2ms
class Solution {
  public boolean judgeCircle(String moves) {
    int [] ascii = new int[128] ;
    for ( char c : moves.toCharArray() ) ascii[c]++ ;
    return ascii['U'] == ascii['D'] && ascii['L'] == ascii['R'] ;
  }
}

// 7ms
class Solution {
  public boolean judgeCircle(String moves) {
    int x = 0 , y = 0 ;
    for ( int i = 0 ; i < moves.length() ; i++ ) {
      switch ( moves.charAt( i ) ) {
        case 'U' : y++ ;
        break ;
        case 'D' : y-- ;
        break ;
        case 'R' : x++ ;
        break ;
        default : x-- ;
      }
    }
    return x == 0 && y == 0 ;
  }
}
