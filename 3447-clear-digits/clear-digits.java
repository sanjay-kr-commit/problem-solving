class Solution {
    public String clearDigits(String s) {
        boolean [] occupied = new boolean[ s.length() ];
        int newLen = s.length();
        for ( int j , i = 0 ; i < s.length() ; i++ ) {
            if ( s.charAt( i ) >= 'a' && s.charAt( i ) <= 'z' ) {
                continue ;
            }
            for ( j = i-1 ; j > -1 ; j-- ) {
                if ( occupied[j] ) continue;
                if ( s.charAt( j ) >= '0' && s.charAt( j ) <= '9' ) continue;
                break ;
            }
            if ( j > -1 ) {
                newLen -= 2 ;
                occupied[ j ] = true;
                occupied[ i ] = true;
            }
        }
        char [] str = new char[newLen];
        int len = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( occupied[i] ) continue;
            str[len++] = s.charAt(i);
        }
        return new String(str, 0, len);
    }
}