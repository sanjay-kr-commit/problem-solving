class Solution {
    public int removeDuplicates(int[] nums) {
        int slowPointer = 0,
            fastPointer = 0 ,
            size = nums.length;
        while ( fastPointer < size ) {
            // initial shift
            nums[slowPointer] = nums[fastPointer++] ;
            if ( fastPointer < size && nums[slowPointer] == nums[fastPointer] ) 
                nums[++slowPointer] = nums[fastPointer++] ;
            while ( fastPointer < size && nums[slowPointer] == nums[fastPointer] ) fastPointer++ ;
            slowPointer++ ;
        }
        return slowPointer ;
    }
}