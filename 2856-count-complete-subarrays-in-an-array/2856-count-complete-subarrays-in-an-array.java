import java.util.HashSet;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int completeSubarraysCount = 0;
        HashSet<Integer> distinct = new HashSet<>();
        for ( int i : nums ) distinct.add( i ) ;
        System.gc();
        int distinctCount = distinct.size();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            HashSet<Integer> subset = new HashSet<>();
            for ( int j = i ; j < nums.length ; j++ ) {
                subset.add( nums[j] ) ;
                if ( subset.size() == distinctCount ) completeSubarraysCount++ ;
                
            }
        }
        return completeSubarraysCount;
    }
}