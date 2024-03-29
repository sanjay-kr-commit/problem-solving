class Solution {
    public int maxWidthRamp(int[] nums) {
        int max = 0 ,
            len = nums.length ;
        int [] rightMax = new int[ len ] ;

        rightMax[ len-1 ] = nums[len-1] ;
        for ( int i = len-2 ; i > -1 ; i-- ) rightMax[i] = Math.max( nums[i] , rightMax[i+1] ) ;

        for ( int i = 0 , j = 0 ; i < len && j < len ; i++ , j++ ) {
            while ( j < len && nums[i] <= rightMax[j] ) j++ ;
            max = Math.max( max , j - i - 1 ) ;
        }

        return max ;
    }
}
