class Solution {
  public void sortColors(int[] nums) {
    int [] colors = new int [ 3 ] ;
    for ( int i : nums ) 
      colors[i]++ ;
    int i = 0 ;
    int c = 0 ;
    for ( int cv : colors ) { 
      int color = cv ;
      while ( color > 0 ) {
        nums[i++] = c ;
        color-- ;
      }
      c++ ;
    }
  }
}
