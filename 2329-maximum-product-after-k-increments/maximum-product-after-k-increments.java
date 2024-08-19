import java.util.PriorityQueue;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        long mod=(long) (1e9)+7;
        if ( nums.length == 1 ) return (int) ((nums[0]+k)%mod) ;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for( int num : nums ) pq.add( (long) num );
        while( k > 0 ){
            long top = pq.remove() ;
            long add = (pq.isEmpty()) ? k : Math.min( k , (pq.peek() - top) + 1 ) ;
            pq.add( top+add ) ;
            k -= (int) add ;
        }
        long product=1;
        while(!pq.isEmpty()) product = ( product * pq.remove() ) %mod ;
        return (int)product;
    }
}