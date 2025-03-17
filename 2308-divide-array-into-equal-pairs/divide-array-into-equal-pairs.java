class Solution {
    public boolean divideArray(int[] nums) {
        int [] frequency = new int[501];
        for ( int i : nums ) frequency[i]++ ;
        for ( int i : frequency ) if ( i % 2 == 1 ) return false;
        return true ;
    }
}