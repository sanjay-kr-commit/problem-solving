class Solution {
    public int[] twoSum(int[] nums, int target) {
        // s and e represent start and end of subarray of nums
        for ( int s = 0 , e = nums.length-1 ; s < nums.length/2 ; s++ , e-- ) {
            // inside this subarray we'll search for remaining number
            // but cycles are more expensive than compare
            // we'll compare element from both direction 
            // and create an offset of one from subarray in order to avoid
            // unnecessary checks
            for ( int ss = s+1 , se = e-1 ; ss < nums.length-s ; ss++ , se-- ) {
                if ( nums[ss] + nums[s] == target ) return new int[] { s , ss } ;
                if ( nums[e] + nums[se] == target ) return new int[] { e , se } ;
            }

        }
        return new int[]{} ;
    }
}