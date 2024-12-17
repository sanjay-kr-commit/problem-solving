class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero = 0 ,
            len = nums.length ,
            product = 1;
        int [] result = new int[len];
        for ( int i = 0 ; zero < 2 && i < len ; i++ ) {
            if ( nums[i] == 0 ) zero++ ;
            else product *= nums[i];
        }
        boolean isZero = zero > 0 ;
        if ( zero < 2 ) for ( int i = 0 ; i < len ; i++ ) {
            if ( nums[i] == 0 ) result[i] = product ;
            else if ( !isZero ) result[i] = product / nums[i]; 
        }
        return result ;
    }
}