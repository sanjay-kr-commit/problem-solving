class Solution {
    public int[] twoSum(int[] nums, int target) {
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int x = target - nums[i] ;
            for ( int j = 0 ; j < nums.length ; j++ ) {
                if ( j == i ) continue;
                if ( x == nums[j] ) return new int [] {i , j } ;
            }
        }
        return new int[2] ;
    }
}