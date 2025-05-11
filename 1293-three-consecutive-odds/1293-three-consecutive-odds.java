class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean first = false , second = false , third = false ;
        for ( int i : arr ) {
            first = second ;
            second = third ;
            third = (i%2) == 1 ;
            if ( first && second && third ) return true ;
        }
        return false ;
    }
}
