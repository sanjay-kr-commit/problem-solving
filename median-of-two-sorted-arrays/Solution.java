import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    PriorityQueue<Integer> min , max ;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        min = new PriorityQueue<>(Collections.reverseOrder()) ;
        max = new PriorityQueue<>() ;
        for ( int i : nums1 ) addNum( i );
        for ( int i : nums2 ) addNum( i );
        return findMedian() ;
    }
    
    public void addNum(int num) {
        min.add( num ) ;
        if ( (!min.isEmpty() && !max.isEmpty() && min.peek() > max.peek())) max.add( min.poll() ) ;
        if ( min.size() > max.size()+1  ) max.add( min.poll() ) ;
        else if ( max.size() > min.size()+1 ) min.add( max.poll() ) ;
    }

    public double findMedian() {
        if (!min.isEmpty() && !max.isEmpty() && min.size() == max.size() ) return (double) (min.peek() + max.peek()) / 2.0 ;
        return min.size() > max.size() ? min.peek() : max.peek() ;
    }
    
}
