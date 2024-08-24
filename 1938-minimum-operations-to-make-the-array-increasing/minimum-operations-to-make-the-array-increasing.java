class Solution {
    public int minOperations(int[] nums) {
        int op = 0 ;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if ( nums[i-1] == nums[i] ) {
                op++ ;
                nums[i]++ ;
            } else if ( nums[i-1] > nums[i] ) {
                op += (nums[i-1] - nums[i])+1;
                nums[i] = nums[i-1]+1 ;
            }
        }
        return op ;
    }
}