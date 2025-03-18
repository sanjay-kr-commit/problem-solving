import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if ( nums.length == 0 ) return 0;
        int best = 0 ;
        Arrays.sort(nums);
        int i = 1 , j = 0 , skipped = 0 ;
        for ( ; i < nums.length ; i++) {
            int t = i-1 ;
            while ( i < nums.length && nums[i-1] == nums[i] ) {
                skipped++ ;
                i++ ;
            }
            if ( i == nums.length && i > 1 && nums[i-1] == nums[i-2] ) skipped++ ;
            if ( i < nums.length && nums[i] != nums[t]+1 ) {
                best = Math.max( best , i - j - skipped) ;
                j = i ;
                skipped = 0 ;
            }
        }
        return Math.max(best,i-j-skipped) ;
    }
}
