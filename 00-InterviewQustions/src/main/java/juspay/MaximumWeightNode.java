package juspay;

import java.util.List;

class MaximumWeightNode {

    public static int maxWeightCell(int n, List<Integer> edge)
    {
        int ans = Integer.MIN_VALUE;
        int result = -1 ;

        int[] weight = new int[ edge.size() ] ;

        for ( int i = 0 ; i < edge.size() ; i++ ) {
            int destination = edge.get( i ) ;
            if ( destination == -1 ) continue;
            weight[destination] += i;
            if ( ans <= weight[destination] ) {
                ans = Math.max(ans, weight[destination] ) ;
                result = destination ;
            }
        }

        if ( ans != Integer.MIN_VALUE ) return result ;
        return -1 ;
    }

}

