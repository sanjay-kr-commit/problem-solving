class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if ( nums.length != 0 ) while ( k != 0 ) {
            int min = Integer.MAX_VALUE;
            int index = nums.length-1 ;
            for ( int i = index ; i > -1 ; i-- ) {
                if ( nums[i] <= min ) {
                    index = i ;
                    min = nums[i] ;
                }
            }
            nums[index] = nums[index] * multiplier;
            k-- ;
        }
        return nums ;
    }
}