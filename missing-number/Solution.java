// 1ms
class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0 , sum2 = 0 ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            sum1 += i+1 ;
            sum2 += nums[i] ;
        }
        return sum1 - sum2 ;
    }
}