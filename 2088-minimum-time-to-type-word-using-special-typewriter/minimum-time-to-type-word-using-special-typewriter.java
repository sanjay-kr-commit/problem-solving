class Solution {
    public int minTimeToType(String word) {
        int timeTaken = 0 ;
        for ( int i = 0 ,
              len = word.length() , prev = 0 ;
              i < len ; i++
        ) {
            int token = word.charAt(i)-'a' ;
            if ( token != prev ) {
                int a = ( token < prev ) ? token : prev ,
                    b = token+prev-a ;
                timeTaken += Math.min( b-a , ('z'-b)+(a-'a')+1 ) ;
            }
            timeTaken++ ;
            prev = token ;
        }
        return timeTaken ;
    }
}