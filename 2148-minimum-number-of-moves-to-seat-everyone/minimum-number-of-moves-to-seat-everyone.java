class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] seatOccupied = new int[101];
        int[] studentOccupied = new int[101];
        for ( int i = 0 ; i < seats.length ; i++ ) {
            seatOccupied[seats[i]]++;
            studentOccupied[students[i]]++;
        }
        int move = 0;
        for ( int i = 0 , j = 0 , k = 0 ; i < students.length ; i++ ) {
            while ( j < 101 && seatOccupied[j] == 0 ) j++ ;
            while ( k < 101 && studentOccupied[k] == 0 ) k++ ;
            if ( j == 101 || k == 101 ) break;
            int diff = Math.min(seatOccupied[j] , studentOccupied[k]);
            move += diff * Math.abs( j - k ) ;
            seatOccupied[j]-=diff;
            studentOccupied[k]-=diff;
        }
        return move;
    }
}