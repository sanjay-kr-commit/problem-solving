class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int distance =  0 ;
        int i , j , lastI , lastJ ;
        for ( i = 1 , j = nums.length-2 , lastI = 0 , lastJ = nums.length-1 ; j > -1 ; j-- , i++ ) {
            if ( nums[i-1] >= nums[i] ) {
                distance = Math.max( distance , i-lastI ) ;
                lastI = i ;
            }
            if ( nums[j+1] >= nums[j] ) {
                distance = Math.max( distance , lastJ-j ) ;
                lastJ = j ;
            }
        }
        distance = Math.max( distance , i-lastI ) ;
        distance = Math.max( distance , lastJ-j ) ;
        return distance;
    }
}