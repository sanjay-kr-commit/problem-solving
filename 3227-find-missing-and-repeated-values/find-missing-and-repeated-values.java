class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int freq[] = new int[ grid.length * grid.length ] ;
        for ( int[] i : grid ) for ( int j : i ) freq[j-1]++ ;
        int dublicate = 0 , missing = 0 ;
        for ( int i = 0 ; i < freq.length ; i++ ) {
            if ( freq[i] == 0 ) missing = i+1 ;
            else if ( freq[i] == 2 ) dublicate = i+1 ;
        }
        return new int[] { dublicate , missing } ;
    }
}