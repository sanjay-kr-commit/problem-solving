import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort( nums ) ;
        int count = 1 , i = nums.length -2 ;
        while ( i > -1 && nums[i] == nums[i+1] ) i-- ;
        if ( i == -1 ) return nums[nums.length-1] ;
        i-- ;
        while ( i > -1 && nums[i] == nums[i+1] ) i-- ;
        if ( i == -1 ) return nums[nums.length-1] ;
        return nums[i] ;
    }
}