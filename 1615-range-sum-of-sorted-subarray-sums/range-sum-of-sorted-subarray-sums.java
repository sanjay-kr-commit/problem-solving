import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {

        int mod = 1000000007 ;

        LinkedList<Integer> list = new LinkedList<>();

        for ( int i = 0 ; i < n ; i++ ) {
            int sum = 0 ;
            for ( int j = i ; j < n ; j++ ) {
                sum += nums[j];
                list.add( sum ) ;
            }
        }

        Collections.sort( list );

        int i = 0 ;
        Iterator<Integer> iterator = list.iterator() ;
        while ( iterator.hasNext() && i < left-1 ) {
            i++ ;
            iterator.next() ;
        }
        int sum = 0 ;
        while ( iterator.hasNext() && i < right ) {
            i++ ;
            sum = ((sum +iterator.next()) % mod );
        }

        return sum ;
    }
}