class Solution {
    public long mostPoints(int[][] questions) {
        long[] cache = new long[questions.length] ;
        for ( int i = 0 ; i < questions.length ; i++ ) cache[i] = -1 ;
        return ans( 0 , 0 , questions , cache  );
    }

    long ans( int index , long sum , int [][] questions , long[] cache ) {
        if ( index >= questions.length ) return sum ;
        if ( cache[index] != -1 ) return cache[index] ;
        cache[index] = Math.max(
            questions[index][0] + ans( index+questions[index][1]+1 , sum , questions , cache ) ,
                ans( index+1 , sum , questions , cache )
        );
        return cache[index] ;
    }

}