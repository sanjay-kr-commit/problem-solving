class Solution {
    public int countSegments(String s) {
      int segment = 0 ; boolean Char = false ; 
      for ( char i : s.toCharArray() ) {
        if ( i == ' ' && Char ) {
          segment++ ;
          Char = false ;
        } else if ( !Char && i != ' ' ) Char = true ;
      }
      if ( Char ) segment++ ;
      return segment ;
    }
}
