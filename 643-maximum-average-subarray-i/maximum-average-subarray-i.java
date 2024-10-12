class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0 ;
        double maxAvg = Double.MIN_VALUE ;
        for ( int i = 0 , len = Math.min( nums.length , k ) ; i < len ; i++ ) {
            sum += nums[i] ;
        }
        maxAvg = (double) sum / k ;
        for ( int i = k , len = nums.length ; i < len ; i++ ) {
            sum -= nums[i-k] ;
            sum += nums[i] ;
            maxAvg = Math.max( (double) sum / k , maxAvg ) ;
        }
        return maxAvg ;
    }
}