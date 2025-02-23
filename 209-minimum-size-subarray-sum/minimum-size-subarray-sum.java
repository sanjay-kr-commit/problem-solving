class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0 , r = 0 , sum = 0 , min = Integer.MAX_VALUE ;
        while ( r < nums.length ) {
            if ( sum >= target ) sum -= nums[l++] ;
            else sum += nums[r++] ;
            if ( sum >= target ) {
                min = Math.min( min , r - l ) ;
            }
        }
        while ( l < r && sum >= target ) {
            sum -= nums[l++] ;
            if ( sum >= target ) min = Math.min( min , r - l ) ;
        }
        return ( min == Integer.MAX_VALUE ) ? 0 : min ;
    }
}