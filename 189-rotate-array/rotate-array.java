class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length ,
            es = k % len ;
        reverse( nums , 0 , len );
        reverse( nums , 0 , es );
        reverse( nums , es , len );

    }
    void  reverse( int [] arr , int s, int e) {
        for ( int i = s , m = (e-s)/2 + s ; i < m ; i++ ) {
            int temp = arr[i] ;
            arr[i] = arr[e-i-1+s] ;
            arr[e-i-1+s] = temp ;
        }
    }
}