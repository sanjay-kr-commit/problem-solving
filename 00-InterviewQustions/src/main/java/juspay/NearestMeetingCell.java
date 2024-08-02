package juspay;

import java.util.ArrayList;
import java.util.List;

class NearestMeetingCell {

    int currentDepth ;

    public int nearestMeetingCells(int n , List<Integer> edges , int c1 , int c2) {
        List<List<Integer>> graph = new ArrayList<>( edges.size() ) ;

        for ( int i = 0 ; i < edges.size() ; i++ ) graph.add( new ArrayList<>( edges.size() ) ) ;

        for ( int i = 0 ; i < edges.size() ; i++ ) {
            if ( edges.get(i) == -1 ) continue;
            graph.get( i ).add( edges.get( i ) ) ;
        }

        boolean[] c1Visited = new boolean[graph.size()] ;

        loopThroughGraph( graph , c1Visited , c1 );
        return loopUpCommonNode( graph , new boolean[ graph.size() ] , c1Visited , c2 , 0 ) ;
    }

    void loopThroughGraph( List<List<Integer>> graph ,  boolean[] visited , int c ) {
        if ( graph.get( c ).isEmpty() || visited[c] ) return;
        visited[c] = true ;
        for ( int i : graph.get( c ) ) loopThroughGraph( graph , visited , i );
    }

    int loopUpCommonNode( List<List<Integer>> graph ,boolean [] visited , boolean [] recordedVisit , int c , int depth ) {
        if ( graph.get( c ).isEmpty() || (visited[c] && !recordedVisit[c]) ) return -1;
        visited[c] = true ;
        if ( recordedVisit[c] ) {
            currentDepth = depth ;
            return c ;
        }
        int nearestVisit = -1 ;
        for ( int i : graph.get( c ) ) {
            int res = loopUpCommonNode( graph , visited , recordedVisit , i , depth + 1 ) ;
            if ( res != -1 && currentDepth < res ) nearestVisit = res ;
        }
        currentDepth = depth ;
        return nearestVisit ;
    }

}
