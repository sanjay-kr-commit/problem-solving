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

// 7 ms
class Solution2 {

  public String reverseWords( String s ) {
    StringBuilder reversed = new StringBuilder() ;
    int i = 0 , t , j = 0 , len = s.length() ;
    while ( i < len ) {
      while ( i < len && s.charAt( i ) == ' ' ) {
        reversed.append( ' ' ) ; 
        i++ ;
      }
      j = i ;
      while ( j < len && s.charAt( j ) != ' ' ) j++ ;
      t = --j ;
      i-- ;
      if ( j < len ) while ( j != i ) reversed.append( s.charAt( j-- ) ) ;
      i = t+1 ;
    }
    return reversed.toString() ;
  }

}

// 5 ms
class Solution3 {
  public String reverseWords( String s ) {
    char array[] = s.toCharArray() ;
    int i = 0 , j = 0 , t , len = s.length() ;
    char tt ;
    while ( i < len ) {
      while ( i < len && array[i] == ' ' ) i++ ;
      j = i ;
      while ( j < len && array[j] != ' ' ) j++ ;
      t = --j ;
      if ( j < len && i < len ) while ( i < j ) {
        tt = array[i] ;
        array[i] = array[j] ;
        array[j] = tt ;
        i++ ; j-- ;
      }
      i = t+1 ;
    }
    StringBuilder reversed = new StringBuilder() ;
    for ( char k : array ) reversed.append( k ) ;
    return reversed.toString() ;
  }
}
