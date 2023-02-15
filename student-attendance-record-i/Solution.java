class Solution {
  public boolean checkRecord(String s) {
    int absent = 0 , late = 0 ;
    for ( char a : s.toCharArray() ) {
      if ( a == 'L' ) late++ ;
      else late = 0 ;
      if ( a == 'A' ) absent++ ;
      if ( absent > 1 || late > 2 ) return false ;
    }
    return !( absent >= 2 || late >= 3 ) ;
  }
}
