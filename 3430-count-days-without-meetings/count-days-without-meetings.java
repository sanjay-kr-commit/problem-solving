import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        int count = 0 ;
        Arrays.sort( meetings , (m , n ) -> {
            if ( m[0] != n[0] ) return Integer.compare(m[0], n[0]);
            return Integer.compare(m[1], n[1]);
        } );
        int start = 0 ;
        for ( int [] meeting : meetings ) {
            if ( meeting[0] > start+1 ) count += meeting[0]-start-1 ;
            if ( start < meeting[1] ) start = meeting[1];
        }
        if ( start < days ) count += days - start ;
        return count ;
    }
}