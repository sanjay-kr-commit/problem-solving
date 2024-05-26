import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Arrays.sort( nums );
        int l = 0 , r = nums.length - 1;
        while ( l < r ) {
            int x = k - nums[l++] ;
            while ( r > l && nums[r] > x ) r-- ;
            if ( x == nums[r] ) {
                operations++ ;
                r-- ;
            }
        }
        return operations ;
    }
}