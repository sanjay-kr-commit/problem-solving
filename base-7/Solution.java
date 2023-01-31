class Solution {
    public String convertToBase7(int num) {
        StringBuilder st = new StringBuilder() ;
        boolean sign = false ;
        if ( num < 0 ) {
            sign = true ;
            num *= -1 ;
        }
        while ( num > 6 ) {
            st.append( num % 7 ) ;
            num /= 7 ;
        }
        if ( num < 0 ) st.append( num*-1 ).append( '-' ) ;
        else st.append( num ) ;
        if ( sign ) st.append( '-' ) ;
        return st.reverse().toString() ;
    }
}
