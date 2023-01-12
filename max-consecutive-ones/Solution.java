class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
      int max = 0 , count = 0 ;
      for ( int i : nums ) {
        if ( i == 0 ){
          max = ( max < count ) ? count : max ;
          count = 0 ;
        } else count++ ;
      }
      return ( max < count ) ? count : max ;
    }
}
