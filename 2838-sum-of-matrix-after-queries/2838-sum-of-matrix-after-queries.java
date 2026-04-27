class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        int [] rows = new int[n] ;
        int [] cols = new int[n] ;
        int rr = n , rc = n ;
        long count = 0 ;
        for ( int i = queries.length -1 ; i > -1 ; i-- ){
            if ( queries[i][0] == 0 && rows[queries[i][1]] == 0 ) {
                count += (long) rc * queries[i][2] ;
                rows[queries[i][1]] = 1;
                rr-- ;
            } else if ( queries[i][0] == 1 && cols[queries[i][1]] == 0 ) {
                count += (long) rr * queries[i][2] ;
                cols[queries[i][1]] = 1;
                rc-- ;
            }
        }
        return count ;
    }
}