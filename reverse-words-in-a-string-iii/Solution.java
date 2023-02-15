// 7 ms
class Solution {
  public String reverseWords(String s) {
    StringBuilder reversed = new StringBuilder() ,
    temp = new StringBuilder() ;
    for ( char i : s.toCharArray() ) {
      if ( i == ' ' ) {
        temp.reverse() ;
        reversed.append( temp ) ;
        temp = new StringBuilder() ;
        reversed.append( ' ' ) ;
      } else temp.append( i ) ;
    }
    if ( temp.length() > 0 ) {
      temp.reverse() ;
      reversed.append( temp ) ;
    }
    return reversed.toString() ;
  }
}
