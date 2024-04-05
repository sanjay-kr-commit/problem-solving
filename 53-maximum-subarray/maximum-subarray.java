// Kadane’s Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE ,
            max_end = 0 ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            max_end += nums[i] ;
            if ( max < max_end ) max = max_end ;
            if ( max_end < 0 ) max_end = 0 ;
        }
        return max ;
    }
}