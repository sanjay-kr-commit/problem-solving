class Solution {
    public long pickGifts(int[] gifts, int k) {
        if ( gifts.length != 0 ) while ( k != 0 ) {
            int min = Integer.MIN_VALUE ;
            int index = 0 ;
            for ( int i = 0 ; i < gifts.length ; i++ ) {
                if ( gifts[i] > min ) {
                    index = i ;
                    min = gifts[i] ;
                }
            }
            gifts[index] = (int) Math.sqrt( gifts[index] ) ;
            k-- ;
        }
        long sum = 0 ;
        for ( int i : gifts ) sum += i ;
        return sum ;
    }
}
