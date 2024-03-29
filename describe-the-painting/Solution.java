import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Long>> splitPainting(int[][] segments) {
        // calculate line dimension
        int start = Integer.MAX_VALUE ,
            end = Integer.MIN_VALUE ;
        for ( int[] segment : segments ) {
            if ( start > segment[0] ) start = segment[0] ;
            if ( end < segment[1] ) end = segment[1] ;
        }
        // create a line
        int [] checkpoints = new int[ end - start + 1 ] ;
        long [] line = new long[ end - start + 1 ] ;
        // fill adjacent points
        for ( int [] segment : segments ) {
            checkpoints[segment[0]-start] = 1 ;
            checkpoints[segment[1]-start] = 1 ;
            line[segment[0]-start] += segment[2] ;
            line[segment[1]-start] -= segment[2] ;
        }
        // calculate new color segment
        int prev = 0 ;
        long color = line[prev] ;
        ArrayList<List<Long>> painting = new ArrayList<>() ;
        for ( int i = 1 ; i < checkpoints.length ; i++ ) {
            if ( checkpoints[i] == 0 ) continue;
            if ( color != 0 ) {
                ArrayList<Long> newSegment = new ArrayList<>();
                newSegment.add((long) prev + start);
                newSegment.add((long) i + start);
                newSegment.add(color);
                painting.add( newSegment ) ;
            }
            color += line[i] ;
            prev = i ;
        }
        if ( prev != line.length -1 ) {
            ArrayList<Long> newSegment = new ArrayList<>() ;
            newSegment.add((long) prev+start ) ;
            newSegment.add((long) line.length+start ) ;
            newSegment.add( color ) ;
            painting.add( newSegment ) ;
        }
        return painting ;
    }

}
