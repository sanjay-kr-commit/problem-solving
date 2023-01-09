class Solution {
    public int thirdMax(int[] nums) {
      if ( nums.length < 1 ) return -1 ;
      int index[] = { -1 , -1 , -1 } ;
      for ( int i = 0 ; i < nums.length ; i++ ) {
        if (
            ( index[0] != -1 && nums[index[0]] == nums[i] ) ||
            ( index[1] != -1 && nums[index[1]] == nums[i] ) ||
            ( index[2] != -1 && nums[index[2]] == nums[i] )
            ) continue ;
        else if ( index[0] == -1 || nums[index[0]] < nums[i] ) {
          index[2] = index[1] ;
          index[1] = index[0] ;
          index[0] = i ;
        } else if ( index[1] == -1 || nums[index[1]] < nums[i] ) {
          index[2] = index[1] ;
          index[1] = i ;
        } else if ( index[2] == -1 || nums[index[2]] < nums[i] ) index[2] = i ;
      }
      return ( index[2] == -1 ) ? nums[index[0]] : nums[index[2]] ;
    }
}
