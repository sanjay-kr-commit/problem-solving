import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0 ;
        Arrays.sort(nums);
        int l = 0 , r = nums.length - 1;
        while ( l < r ) {
            long sum = nums[l] + nums[r];
            if ( sum > upper ) r-- ;
            else if ( sum < lower ) l++ ;
            else break;
        }
        int lowerBound = l , upperBound = r ;
        for ( int i = l ; i <= r ; i++ ) {
            int k = i+1 ;
            while ( k < r && nums[k]+nums[i] < lower ) k++ ;
            int j = r ;
            while ( j >= k && nums[j]+nums[i] > upper ) j-- ;
            count += j-k+1 ;
        }
        return count ;
    }
    
}