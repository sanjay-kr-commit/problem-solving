class Solution {
    int search( int x , int [] nums ) {
        int l = 0 , r = nums.length ;
        while ( l < r ) {
            int m = l + ( r - l ) / 2 ;
            if ( nums[m] == x ) return m ;
            else if ( nums[m] > x ) r = m-1 ;
            else l = m+1 ;
        }
        if ( l < nums.length && nums[l] == x ) return l ; 
        return -1 ;
    }
    public int[] twoSum(int[] nums, int target) {
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int x = target - nums[i] ;
            int j = search( x , nums ) ;
            if ( j == -1 || j == i ) continue ;
            if ( i > j ) return new int [] { j+1 , i+1 } ;
            return new int [] { i+1 , j+1 } ;
        }
        return new int [] {} ;
    }
}