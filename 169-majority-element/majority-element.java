class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 , max = 0 ;
        for ( int i : nums ) {
            if ( count == 0 ) max = i ;
            if ( i == max ) count++ ;
            else count-- ;
        }
        return max ;
    }
}