import java.util.PriorityQueue;

class Solution {
    class Pair {
        int index , value ;
    }
    public int[] topKFrequent(int[] nums, int k) {
        int [] result = new int[k];
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for ( int i : nums ) {
            if ( i > max ) max = i;
            if ( i < min ) min = i;
        }
        int [] freq = new int [ max - min + 1 ];
        for ( int i : nums ) freq[i-min]++ ;
        PriorityQueue <Pair> queue = new PriorityQueue<>((a,b)-> Integer.compare(a.value, b.value) * -1) ;
        for ( int i = 0 ; i < freq.length ; i++ ) {
            Pair pair = new Pair() ;
            pair.index = i + min ;
            pair.value = freq[i] ;
            queue.add(pair) ;
        }
        for ( int i = 0 ; i < k ; i++ ) {
            Pair pair = queue.poll() ;
            result[i] = pair.index ;
        }
        return result ;
    }
}