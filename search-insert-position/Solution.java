class Solution {
    public static int searchInsert(int[] nums, int target) {
        int low = 0 , high = nums.length -1 ;
        // when it will become zero when the pointer at same index
        while ( high - low > 1 ) {
            int mid = (high+low)/2 ;
            if ( nums[mid] < target ) low = mid+1 ;
            else high = mid ; 
        }
        if ( nums[low] == target ) return low ;
        else if ( target < nums[low] ) return low ;
        else if ( target > nums[high] ) return high+1 ;
        return low + 1 ;
    }
}