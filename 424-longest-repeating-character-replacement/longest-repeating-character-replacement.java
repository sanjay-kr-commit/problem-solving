import java.util.Arrays;

class Solution {

    public int characterReplacement(String s, int k) {
        int maxLen = 0 ;
        int [] freq = new int[26];
        int max = 0 , count = 0 , i = 0 , j = 0 , index ;
        while ( i < s.length() ) {
            index = s.charAt(i++) - 'A';
            freq[index]++ ;
            count++ ;
            if ( freq[index] > max ) max = freq[index];
            if ( count-max <= k ) continue;
            if ( maxLen < count ) maxLen = count-1 ;
            index = s.charAt(j++) - 'A';
            freq[index]-- ;
            max = max( freq ) ;
            count-- ;
        }
        if ( maxLen < count ) maxLen = count ;
        return maxLen ;
    }

    int max( int [] a ) {
        int max = Integer.MIN_VALUE ;
        for ( int i = 0 ; i < a.length ; i++ ) {
            if ( a[i] > max ) max = a[i] ;
        }
        return max ;
    }

}