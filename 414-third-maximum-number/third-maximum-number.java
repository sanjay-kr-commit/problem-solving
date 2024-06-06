import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE , secondMax = max , thirdMax = max ;
        for ( int num : nums ) {
            if ( num > max ) {
                thirdMax = secondMax ;
                secondMax = max ;
                max = num ;
            } else if ( num > secondMax && num < max ) {
                thirdMax = secondMax ;
                secondMax = num ;
            } else if ( num > thirdMax && num < secondMax ) thirdMax = num ;
        }
        return (int) ((thirdMax == Long.MIN_VALUE ) ? max : thirdMax) ;
    }
}