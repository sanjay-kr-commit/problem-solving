import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        if ( times.length <= targetFriend ) return -1 ;
        targetFriend = times[targetFriend][0] ;
        Arrays.sort( times , Comparator.comparingInt(o -> o[0]));
        int [] chair = new int[times.length];
        int lastOccupied = 0;
        outer:
        for ( int [] time : times ) {
            for ( int i = 0 ; i < lastOccupied ; i++ ) {
                if ( chair[i] <= time[0] ) {
                    if ( time[0] == targetFriend ) return i ;
                    chair[i] = time[1] ;
                    continue outer ;
                }
            }
            if ( time[0] == targetFriend ) return lastOccupied ;
            chair[lastOccupied++] = time[1] ;
        }
        return lastOccupied ;
    }
}