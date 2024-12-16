public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length() ,
            filled = 0 ,
            index = 0 ,
            row = 0 , temp ;
        boolean flip = false;
        if (numRows < 2 || len < numRows) return s;
        char [] chars = new char[ len ] ;
        chars[filled++] = s.charAt( index ) ;
        while ( filled < len ) {
            temp = (flip) ? (row-1) * 2 + 2 : ( numRows - row - 2 ) * 2 + 2 ;
            flip = !flip ;
            if ( temp == 0 ) continue;
            index += temp ;
            if ( index >= len ) {
                flip = false ;
                index = ++row ;
            }
            chars[filled++] = s.charAt( index ) ;
        }
        return new String(chars);
    }
}