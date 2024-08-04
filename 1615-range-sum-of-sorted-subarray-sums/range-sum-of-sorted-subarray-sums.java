import java.util.PriorityQueue;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int i = 0 ; i < n ; i++ ) {
            int sum = 0 ;
            for ( int j = i ; j < n ; j++ ) {
                sum += nums[j];
                pq.add( sum ) ;
            }
        }

        for ( int i = 1 ; i < left ; i++ ) pq.poll() ;
        int sum = 0 ;
        for ( int i = left ; i <= right && pq.peek() != null ; i++ ) {
            sum = ((sum +pq.poll())  % 1000000007);
        }
        return sum ;
    }
}