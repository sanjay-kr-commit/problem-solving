class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {

        int smallest = nums[0] , largest = 0 ;

        for ( int i : nums ) {
            smallest = Math.min(smallest , i);
            largest += i ;
        }

        int[] freq = new int[largest-smallest+1];

        for ( int i = 0 ; i < nums.length ; i++ ) {
            int sum = 0 ;
            for ( int j = i ; j < nums.length ; j++ ) {
                sum += nums[j] ;
                freq[sum-smallest]++;
            }
        }

        int mod = (int) 1e9 + 7 , l = left , r = right-l , i = 0 ;
        int sum = 0 ;

        while ( l > 1 ) {
            while ( i < freq.length && freq[i] == 0 ) i++ ;
            if ( i == freq.length ) break;
            freq[i]-- ;
            l-- ;
        }

        while ( r > -1 ) {
            while ( i < freq.length && freq[i] == 0 ) i++ ;
            if ( i == freq.length ) break;
            freq[i]-- ;
            sum = (sum + ( i + smallest))%mod ;
            r-- ;
        }

        return sum ;
    }
}