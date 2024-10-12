class Solution {
    public String removeStars(String s) {
        char [] stack = new char[ s.length() ] ;
        int size = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( s.charAt( i ) == '*' && size > 0 ) size-- ;
            else stack[size++] = s.charAt( i ) ;
        }
        return new String( stack , 0 , size ) ;
    }
}