class Solution { 
    public int[] productExceptSelf(int[] nums) {
        int [] zeroIndexes = new int[nums.length];
        int zeroCount = 0 , product = 1 ;
        int [] ans = new int[nums.length];
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( nums[i] == 0 ) zeroIndexes[zeroCount++] = i ;
            else product *= nums[i] ;
        }
        for ( int i = 0 ; i < nums.length ; i++ ) ans[i] = 0 ;
        if ( zeroCount == 1 ) ans[zeroIndexes[0]] = product ;
        else if ( zeroCount == 0 ) {
            for ( int i = 0 ; i < nums.length ; i++ ) {
                ans[i] = product/nums[i] ;
            }
        }
        return ans ;
    }
}