// 2ms
class Solution {
  public String reverseStr(String s, int k) {
    char ss[] = s.toCharArray() ;
    for ( int i = 0 ; i < ss.length ; i += 2*k ) {
      int l = i , r = ( i + k -1 >= ss.length ) ?ss.length -1 : i+k-1 ;
      while ( l < r ) {
        char temp = ss[l] ;
        ss[l++] = ss[r] ;
        ss[r--] = temp ;
      }
    }
    StringBuilder r = new StringBuilder() ;
    for ( char i : ss ) r.append( i ) ;
    return r.toString() ;
  }
}

// 1ms
class Solution2 {
  public String reverseStr( String s , int k ) {
    StringBuilder reversedString = new StringBuilder() ;
    int n = 0 , len = s.length() ;
    while (true) {
      int firstHalfStart = n*2*k , firstHalfEnd = (n*2+1)*k ;
      int secondHalfStart = (n*2+1)*k , secondHalfEnd = (n*2+2)*k ;
      if ( firstHalfStart >= len ) break ;
      if ( firstHalfEnd >= len ) firstHalfEnd = len ;
      StringBuilder temp = new StringBuilder() ;
      temp.append( s.substring( firstHalfStart , firstHalfEnd ) ) ;
      temp.reverse() ;
      if ( secondHalfStart < len ) {
        if ( secondHalfEnd >= len ) secondHalfEnd = len ;
        temp.append( s.substring( secondHalfStart , secondHalfEnd ) ) ;
      }
      reversedString.append( temp ) ;
      n++ ;
    }
    return reversedString.toString() ;
  }
}
