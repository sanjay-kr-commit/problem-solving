class MedianFinder {

    PriorityQueue<Integer> min , max ;

    public MedianFinder() {
        max = new PriorityQueue<>() ;
        min = new PriorityQueue<>(Collections.reverseOrder() ) ;
    }

    public void addNum(int num) {
        min.add( num ) ;
        if ( (!min.isEmpty() && !max.isEmpty() && min.peek() > max.peek())) max.add( min.poll() ) ;
        if ( min.size() > max.size()+1  ) max.add( min.poll() ) ;
        else if ( max.size() > min.size()+1 ) min.add( max.poll() ) ;
    }

    public double findMedian() {
        if ( min.size() > max.size() ) return min.peek() ;
        else if ( max.size() > min.size() ) return max.peek() ;
        return (double) (min.peek() + max.peek())/2.0 ;
    }
}
