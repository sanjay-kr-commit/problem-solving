import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> min , max ;

    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        min.add(num);
        if (!max.isEmpty() && min.peek() > max.peek()) max.add(min.poll());
        if (min.size() > max.size() + 1) max.add(min.poll());
        else if ( max.size() > min.size() + 1 ) min.add(max.poll());
    }

    public double findMedian() {
        if ( min.size() > max.size() ) return min.peek();
        else if ( max.size() > min.size()) return max.peek();
        else return (double) (max.peek() + min.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */