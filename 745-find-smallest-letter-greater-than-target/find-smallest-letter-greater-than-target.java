class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0 ;
        while ( i < letters.length && letters[i] <= target ) i++ ;
        if ( i == letters.length ) i = 0 ;
        return letters[i] ;
    }
}