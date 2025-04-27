class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0 ;
        for ( int i = 2 ; i < nums.length ; i++ ) {
            if ( (nums[i]+nums[i-2]) == (((double)nums[i-1])/2.0) )
                count++;
        }
        return count;
    }
}