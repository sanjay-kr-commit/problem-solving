import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int [] freq = new int[101];
        int sum = 0 ;
        for ( int num : nums ) {
            sum += num;
            freq[num]++;
        }
        List<Integer> result = new ArrayList<>( nums.length );
        int remove = 0 , index = 100 ;
        while ( index > 0 && remove <= sum ) {
            while ( index > 0 && freq[index] == 0 ) index-- ;
            if ( index > 0 ) {
                result.add( index ) ;
                remove += index ;
                sum -= index ;
                freq[index]--;
            }
        }

        return result ;
    }
}