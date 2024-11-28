class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length ,
                extraSpace = k % len ;
        int [] arr = new int[ extraSpace ] ;
        for ( int j = 0, i = len - extraSpace ; i < len ; i++ , j++ ) {
            arr[j] = nums[i] ;
        }
        for ( int i = len - extraSpace - 1  , j = len -1 ; i > -1 ; i-- , j-- ) {
            nums[j] = nums[i] ;
        }
        for ( int i = 0 ; i < extraSpace ; i++) {
            nums[i] = arr[i] ;
        }
    }
}