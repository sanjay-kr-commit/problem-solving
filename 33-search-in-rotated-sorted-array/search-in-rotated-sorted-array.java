class Solution {
    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length-1 ;
        if ( nums[0] > nums[nums.length-1] ) {
            int i = nums.length-1 ;
            while ( i > 0 && nums[i] > nums[i-1] ) i-- ;
            if ( target < nums[0] ) l = i ;
            else r = i-1 ;
        }
        while ( l < r ) {
            int mid = (l + (r-l)/2) ;
            if ( nums[mid] == target ) return mid ;
            else if ( nums[mid] < target ) l = mid+1 ;
            else r = mid-1 ;
        }
        if ( l == r && nums[l] == target ) return l ;
        return -1 ;
    }
}