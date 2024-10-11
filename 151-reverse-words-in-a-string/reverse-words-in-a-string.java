class Solution {
    public String reverseWords(String s) {
        char [] str = new char[ s.length()*2 ];
        char [] buffer = new char[ s.length() ];
        int occupied = 0 , buff = 0 ;
        for ( int i = s.length()-1 ; i > -1 ; i-- ) {
            while ( i > -1 && s.charAt( i ) == ' ' ) i-- ;
            while ( i > -1 && s.charAt( i ) != ' ' ) buffer[buff++] = s.charAt( i-- ) ;
            if ( buff > 0 ) {
                while ( buff > 0 ) {
                    str[occupied++] = buffer[--buff] ;
                }
                str[occupied++] = ' ' ;
            }
        }
        if ( occupied > 0 ) occupied-- ;
        return new String( str , 0, occupied ) ;
    }
}