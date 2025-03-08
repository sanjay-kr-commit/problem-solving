class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if ( s1.length() != s2.length() ) return false;
        int [] frequency = new int[26];
        for ( int i : s1.toCharArray() ) frequency[ i - 'a' ]++;
        for ( int i : s2.toCharArray() ) frequency[ i - 'a' ]--;
        for ( int i : frequency ) if ( i != 0 ) return false ;
        int countMismatch = 0;
        for ( int i = 0 ; i < s1.length() ; i++ ) if ( s1.charAt(i) != s2.charAt(i) ) countMismatch++;
        return countMismatch == 2 || countMismatch == 0 ;
    }
}