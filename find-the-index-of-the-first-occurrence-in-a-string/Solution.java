class Solution {
  public int strStr(String haystack, String needle) {
    int needleL = needle.length() ;
    for ( int i = 0 ; i <= haystack.length() - needleL ; i++ ) {
      if ( haystack.substring( i , i + needleL).equals( needle)) return i ;
    }
    return -1 ;
  }
}
