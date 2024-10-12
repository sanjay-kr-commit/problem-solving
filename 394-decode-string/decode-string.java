class Solution {
    int index ;
    public String decodeString(String s) {
        StringBuilder st = new StringBuilder(s);
        index = 0 ;
        decode( st );
        return st.toString() ;
    }

    void decode( StringBuilder st ) {
        int count = 0 , startIdx = index-1 , endIdx = index+1 ;
        long temp = 1 ;
        if ( index > 0 && st.charAt( index ) == '[' ) {
            for (; startIdx > -1 && isDigit(st.charAt(startIdx)); startIdx--) {
                temp *= 10 ;
                temp += st.charAt(startIdx)-'0' ;
            }
            while ( temp > 1 ) {
                count *= 10 ;
                count += (int) (temp % 10);
                temp /= 10 ;
            }
            StringBuilder buff = new StringBuilder() ;
            for ( ; endIdx < st.length() && st.charAt( endIdx ) != ']' ; endIdx++ ) {
                if ( st.charAt( endIdx ) == '[' ) {
                    endIdx = index+1 ;
                    buff = new StringBuilder() ;
                 //   int prev = index ;
                    index = endIdx ;
                    decode( st );
                    //index = prev;
                }
                buff.append(st.charAt(endIdx));
            }
            int buffLen = buff.length();
            for ( int i = buffLen , len = buffLen*count ; i < len ; i++ ) {
                buff.append( buff.charAt( i % buffLen ) ) ;
            }
            st.replace( startIdx+1 , endIdx+1 , buff.toString() ) ;
        } else while ( index < st.length() ) {
            if ( st.charAt(index) == '[' ) decode( st );
            index++ ;
        }
    }

    boolean isDigit( char c ) {
        return c >= '0' && c <= '9';
    }

}