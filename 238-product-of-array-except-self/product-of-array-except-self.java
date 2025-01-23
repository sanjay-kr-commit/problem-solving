class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroIndex = -1 ;
        int product = 1 ;
        int[] result = new int[nums.length];
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( nums[i] != 0 ) product *= nums[i];
            else if ( zeroIndex == -1 ) zeroIndex = i;
            else return result ;
        }
        if ( zeroIndex != -1 ) result[zeroIndex] = product;
        else for ( int i = 0 ; i < nums.length ; i++ ) {
            result[i] = product/nums[i];
        }
        return result ;
    }
}