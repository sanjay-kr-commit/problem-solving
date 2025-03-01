class Solution {
  public int[] applyOperations(int[] nums) {
    for ( int i = 0 ; i < nums.length-1 ;i++ ) {
      if ( nums[i] != nums[i+1] ) continue ;
      nums[i] *= 2 ;
      nums[i+1] = 0 ;
    }
    int i = 0 , j = 0 ;
    while ( j < nums.length ) {
      if ( nums[j] != 0 ) nums[i++] = nums[j] ;
      j++ ;
    }
    while ( i < nums.length ) nums[i++] = 0 ;
    return nums ;
  }
} 
