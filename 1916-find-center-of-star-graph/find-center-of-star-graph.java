class Solution {
    public int findCenter(int[][] edges) {
        int[] freq = new int[ ((int) 1e5)+1 ] ;
        int max = 0 , name = 0 ;
        for ( int i = 0 ; i < edges.length ; i++ ) {
            freq[edges[i][0]]++ ;
            if ( freq[edges[i][0]] > max ){
                max = freq[edges[i][0]] ;
                name = edges[i][0] ;
            }
            freq[edges[i][1]]++ ;
            if ( freq[edges[i][1]] > max ){
                max = freq[edges[i][1]] ;
                name = edges[i][1] ;
            }
        }
        return name ;
    }
}