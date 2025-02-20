class Solution {
  public int findPeakElement(int[] nums) {
    int l = 0 , r = nums.length-1 , m = -1 ;
    while ( l < r ) {
      m = l + ( r - l ) / 2 ;
      if ( getValue( m-1 , nums ) < nums[m] && getValue( m+1 , nums ) < nums[m] ) return m ;
      else if ( getValue( m-1 , nums ) > nums[m] ) r = m ;
      else l = m+1 ;
    }
    return l ;
  }
  int getValue( int index , int [] nums ) {
    if ( index < 0 || index >= nums.length ) return Integer.MIN_VALUE ;
    return nums[index] ;
  }
}
