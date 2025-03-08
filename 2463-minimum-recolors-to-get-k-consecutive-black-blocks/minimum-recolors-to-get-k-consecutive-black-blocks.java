class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0 , j = 0 , w = 0 ;
        int distance = Integer.MAX_VALUE ;
        while ( j < Math.min( blocks.length(), k ) ) {
            if ( blocks.charAt(j) == 'W' ) w++ ;
            j++ ;
        }
        if ( w < distance ) distance = w ;
        while ( j < blocks.length() ) {
            if ( blocks.charAt(i++) == 'W' ) w-- ;
            if ( blocks.charAt(j) == 'W' ) w++ ;
            if ( w < distance ) distance = w ;
            j++ ;
        }
        return distance;
    }
}