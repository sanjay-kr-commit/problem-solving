import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = -1;
        int cnt = 0;
        for ( Integer num : nums ) {
            if ( cnt == 0 ) {
                dominant = num;
                cnt++;
            } else if ( num == dominant ) cnt++;
            else cnt--;
        }
        int maxC = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            if( nums.get(i) == dominant ) maxC++;
        }
        int c = 0;
        for( int i = 0 ; i < n ; i++ ) {
            if( nums.get(i) == dominant ) c++;
            if( c * 2 > ( i+1 ) && ( maxC-c ) * 2 > ( n-i-1 ) ) return i;
        }
        return -1;
    }
}