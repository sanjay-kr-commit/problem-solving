import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        int underK = 0 ;
        k++ ;
        for ( int num : nums ) {
            if ( num < k ) nums[underK++] = num ;
        }
        k-- ;
        Arrays.sort(nums , 0 , underK );
        int l = 0 , r = underK-1 ;
        int x ;
        while ( l < r ) {
            x = k - nums[l++] ;
            while ( l < r && nums[r] > x ) r-- ;
            if ( nums[r] == x ) {
                r-- ;
                operations++ ;
            }
        }
        return operations ;
    }
}