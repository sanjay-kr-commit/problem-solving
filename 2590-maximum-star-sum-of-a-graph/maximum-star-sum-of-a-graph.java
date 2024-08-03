import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int max= Integer.MIN_VALUE ;

        int n=vals.length;
        for ( int i : vals ) max = Math.max( max , i ) ;

        List<PriorityQueue<Integer>> graph = new ArrayList<>();

        for ( int i = 0 ; i < n ; i++ ) graph.add( new PriorityQueue<>( Collections.reverseOrder() )) ;

        for ( int [] edge : edges ) {
            graph.get( edge[0] ).add( vals[edge[1]] );
            graph.get( edge[1] ).add( vals[edge[0]] );
        }

        for ( int i = 0 ; i < graph.size() ; i++ ) {
            if ( graph.get( i ).isEmpty() ) continue;
            PriorityQueue<Integer> node = graph.get( i ) ;
            int edgeCrossed = k ;
            int sum = vals[i] ;
            while ( !node.isEmpty() && edgeCrossed-- > 0 ) {
                int nodeWeight = node.poll();
                max = Math.max( max , sum ) ;
                sum += nodeWeight ;
            }
            max = Math.max( max , sum ) ;
        }

        return max;
    }
}