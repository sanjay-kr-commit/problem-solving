class Solution {
    public int[] diStringMatch(String s) {
        int inc = 0 , len = s.length() , dec = s.length() ;
        int[] ans = new int[ len+1 ] ;
        for ( int i = 0 , idx = 0 ; i < len ; i++ ) {
            if ( s.charAt( i ) == 'I' ) ans[idx++] = inc++ ;
            else ans[idx++] = dec-- ;
        }
        ans[len] = (inc<len)?inc:dec ;
        return ans ;
    }
}