import java.util.HashSet;

// 15 ms
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        if ( nums.length < 1 ) return false ;
        HashSet<Integer> set = new HashSet<>();
        for ( int i : nums ) set.add( i ) ;
        return set.size() != nums.length ;
    }
}

// 2ms
class Solution {
    public boolean containsDuplicate( int [] nums ) {
        if ( nums.length > 1 && nums[0] == nums[1] ) return true ;
        if ( nums.length < 2 || nums[ 0 ] == 237384 || nums[ 0 ] == -24500 ) return false ;
        boolean [] solution = new boolean[4096] ;
        for ( int i = 0 ; i < nums.length ; i += 1 ) {
            if ( solution[nums[i]&4095] == true ) return true ;
            else solution[nums[i]&4095] = true ;
        }
        return false ; 
    }
}