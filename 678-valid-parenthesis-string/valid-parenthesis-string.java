class Solution {
    public boolean checkValidString(String s) {
        return isValid( s , 0 , 0 , s.length() , new int [ s.length()+1 ] ) ;
    }

    boolean isValid(String s , int size , int index , int len , int [] dp ) {
        if ( dp[index] != 0 ) return dp[index] == 1;
        while ( index < len && size > -1 ) {
            char ch = s.charAt(index) ;
            if ( ch == '(' ) size++ ;
            else if ( ch == ')' ) size-- ;
            else {
                if ( isValid( s , size+1 , index+1 , len ,dp ) || isValid( s , size-1 , index+1 , len, dp ) ) {
                    dp[index] = 1 ;
                    return true ;
                } else {
                    dp[index] = -1 ;
                }
            }
            index++ ;
        }
        return size == 0 ;
    }

}