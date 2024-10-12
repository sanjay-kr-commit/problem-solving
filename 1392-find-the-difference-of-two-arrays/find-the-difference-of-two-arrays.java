import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        ArrayList<List<Integer>> diff = new ArrayList<>(2);
        ArrayList<Integer> num1Diff = new ArrayList<>(nums1.length);
        ArrayList<Integer> num2Diff = new ArrayList<>(nums2.length);
        boolean [] freq = new boolean[2001];
        for ( int num : nums1 ) freq[num+1000] = true ;
        for ( int num : nums2 ) freq[num+1000] = false ;
        for ( int i = 0 ; i < 2001 ; i++ ) {
            if ( freq[i] ) {
                num1Diff.add( i-1000 ) ;
                freq[i] = false ;
            }
        }
        for ( int num : nums2 ) freq[num+1000] = true ;
        for ( int num : nums1 ) freq[num+1000] = false ;
        for ( int i = 0 ; i < 2001 ; i++ ) {
            if ( freq[i] ) num2Diff.add( i-1000 ) ;
        }
        diff.add( num1Diff ) ;
        diff.add( num2Diff ) ;
        return diff ;
    }
}