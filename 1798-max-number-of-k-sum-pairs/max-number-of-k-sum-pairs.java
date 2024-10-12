import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort( nums );
        int operationCount = 0 ;
        for ( int l = 0 , r = nums.length-1 ; l < r ; ) {
            if ( nums[l] + nums[r] == k ) {
                operationCount++ ;
                l++ ;
                r-- ;
            } else if ( nums[l] + nums[r] > k ) r-- ;
            else l++ ;
        }
        return operationCount;
    }
}