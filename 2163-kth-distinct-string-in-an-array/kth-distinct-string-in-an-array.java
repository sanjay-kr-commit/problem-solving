import java.util.HashMap;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> freq = new HashMap<>() ;
        for ( String string : arr ) {
            if ( freq.containsKey( string ) ) freq.put( string , freq.get(string)+1 ) ;
            else freq.put( string , 1 ) ;
        }
        int i = 0 , j = 0 ;
        for ( ; j < arr.length && i < k ; j++ ) {
            if ( freq.get(arr[j]) == 1 ) i++ ;
        }
        return ( j > arr.length || i < k ) ? "" : arr[j-1] ;
    }
}