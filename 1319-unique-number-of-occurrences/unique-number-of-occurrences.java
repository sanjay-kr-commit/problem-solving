class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int [] freq = new int[2001];
        int [] occurrences = new int[2001];
        for ( int i = 0 ; i < 2001 ; i++ ) occurrences[i] = -1001 ;
        for ( int i = 0 ; i < arr.length ; i++ ) freq[arr[i]+1000]++ ;
        for ( int i = 0 ; i < 2001 ; i++ ) {
            if ( freq[i] == 0 ) continue;
            int index = freq[i] ;
            int value = i-1000 ;
            if ( occurrences[index] != -1001 ) return false ;
            else occurrences[index] = value ;
        }
        return true ;
    }
}