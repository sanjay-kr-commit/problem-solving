class Solution {
    public boolean check(int[] nums) {
        boolean shiftFound = false ;
        for ( int i = 0 ; i < nums.length-1 ; i++ ) {
            if ( nums[i] <= nums[i+1] ) continue;
            if ( nums[0] >= nums[nums.length-1] && !shiftFound ) {
                shiftFound = true ;
                continue;
            }
            return false;
        }
        return true ;
    }
}
