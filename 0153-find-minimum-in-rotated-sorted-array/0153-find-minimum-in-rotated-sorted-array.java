class Solution {
    public int findMin(int[] nums) {
        if ( nums.length == 1 || nums[0] < nums[nums.length-1]  ) return nums[0];
        int left = 0, right = nums.length-1 ,
            prior , mid = 0 ;
        while ( left <= right ) {
            prior = mid ;
            mid = left + (right-left)/2;
            if ( nums[mid] < nums[prior] ) right = mid - 1;
            else left = mid + 1;
        }
        return nums[left] ;
    }
}