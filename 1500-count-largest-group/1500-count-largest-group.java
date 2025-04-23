import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countLargestGroup(int n) {
        int max = 0 ;
        n++ ;
        HashMap<Integer,Integer> cache = new HashMap<>();
        for ( int i = 1 ; i < n ; i++ ) {
            int sum = 0 , x = i ;
            while ( x > 0 ) {
                sum += x % 10 ;
                x /= 10 ;
            }
            cache.put( sum , cache.getOrDefault( sum , 0 ) + 1 ) ;
        }
        for ( Map.Entry<Integer,Integer> entry : cache.entrySet() ) {
            max = Math.max( max , entry.getValue() ) ;
        }
        int count = 0 ;
        for ( Map.Entry<Integer,Integer> entry : cache.entrySet() ) {
            if ( entry.getValue() == max ) count++ ;
        }
        return count ;
    }
}