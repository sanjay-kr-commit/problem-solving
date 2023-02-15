class Solution {
  public boolean detectCapitalUse(String word) {
    if ( word.length() <=  1 ) return true ;
    boolean capital[] = new boolean[word.length()] ;
    for ( int i = 0 ; i < word.length() ; i++ ) capital[i] = ( word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' ) ;
    if ( !capital[0] && capital[1] ) return false ;
    for ( int i = 2 ; i < capital.length ; i++ ) {
      if ( capital[i] != capital[i-1] ) return false ;
    }
    return true ;
  }
}
