import java.util.HashMap;

import java.util.HashSet;

// 27 ms
class Solution1 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>() ;
        for ( int i : nums ) {
            if ( set.contains( i ) ) set.remove( i ) ;
            else set.add( i ) ;
        }
        for ( int i : set ) return  i ;
        return -1 ;
    }
}

// 7ms
class Solution {
    public int singleNumber(int[] nums) {
        if ( nums.length == 1 ) return nums[0] ;
        int unique = 0 ;
        for ( int i : nums ) unique ^= i ;
        return unique ;
    }
}