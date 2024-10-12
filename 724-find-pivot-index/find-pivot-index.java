class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0 , prefixSum = 0 , prev ;
        for ( int num : nums ) sum += num;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            sum -= nums[i];
            prev = nums[i];
            if ( sum == prefixSum ) return i;
            prefixSum += prev ;
        }
        return -1 ;
    }
}