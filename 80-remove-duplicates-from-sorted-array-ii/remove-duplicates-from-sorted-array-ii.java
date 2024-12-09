class Solution {
    public int removeDuplicates(int[] nums) {
      int fastPointer = 0 ,
          slowPointer = 0 ,
          size = nums.length ;
      while ( fastPointer < size ) {
        nums[slowPointer] = nums[fastPointer++] ;
        if ( fastPointer < size && nums[slowPointer] == nums[fastPointer] ) {
          nums[++slowPointer] = nums[fastPointer++] ;
        } 
        while ( fastPointer < size && nums[fastPointer] == nums[slowPointer] ) fastPointer++ ;
        slowPointer++ ;
      }
      return slowPointer ;
    }
}
