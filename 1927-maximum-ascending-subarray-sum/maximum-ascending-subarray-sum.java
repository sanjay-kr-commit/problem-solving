class Solution {
    public int maxAscendingSum(int[] nums) {
        if ( nums.length == 0 ) return 0; 
        int max = nums[0] ;
        for ( int i = 1 , count = nums[0] ; i < nums.length ; i++ ) {
            if ( nums[i] <= nums[i-1] ) count = 0 ;
            count += nums[i] ;
            max = Math.max( max, count ) ;
        }
        return max;
    }
}