class Solution {
    public int[] diStringMatch(String s) {
        int[] ans = new int[ s.length()+1] ;
        int inc = 0 , dec = s.length() ;
        for ( int i = 0 , idx = 0 ; i < s.length() ; i++ ) {
            if ( s.charAt( i ) == 'I' ) ans[idx++] = inc++ ;
            else ans[idx++] = dec-- ;
        }
        if ( inc < s.length() ) ans[s.length()] = inc ;
        else ans[s.length()] = dec ;
        return ans ;
    }
}