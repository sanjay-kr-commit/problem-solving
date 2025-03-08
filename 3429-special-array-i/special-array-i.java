class Solution {
    public boolean isArraySpecial(int[] nums) {
        if ( nums.length < 2 ) return true ;
        for ( int i = nums.length-2 ; i > -1 ; i-- ) {
            if ((nums[i] % 2 == 0) == (nums[i + 1] % 2 == 0)) return false ;
        }
        return true ;
    }
}