class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        k -= 2 ;
        for ( int i = 0 , previous = colors[colors.length-1] , l = 0 ; i < colors.length+k ; i++ ) {
            if ( previous == colors[i%colors.length] ) {
                l = 0 ;
                continue;
            }
            previous = colors[i%colors.length] ;
            if ( l < k ) l++ ;
            else count++;
        }
        return count ;
    }
}