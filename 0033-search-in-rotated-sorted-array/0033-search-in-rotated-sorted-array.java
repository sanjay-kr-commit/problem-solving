class Solution {

    public int search(int[] nums, int target) {
        int offset = findMin(nums) ,
            l = 0 , r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r-l) / 2;
            int absIndex = (mid+offset)%nums.length;
            if ( nums[absIndex] == target ) return absIndex ;
            else if ( nums[absIndex] > target ) r = mid - 1;
            else l = mid + 1;
        }
        return -1 ;
    }

    int findMin(int[] nums) {
        if ( nums.length == 1 || nums[0] < nums[nums.length-1]  ) return 0;
        int left = 0, right = nums.length-1 ,
            prior , mid = 0 ;
        while ( left <= right ) {
            prior = mid ;
            mid = left + (right-left)/2;
            if ( nums[mid] < nums[prior] ) right = mid - 1;
            else left = mid + 1;
        }
        return left ;
    }
}