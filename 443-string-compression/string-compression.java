class Solution {
    public int compress(char[] chars) {
        int compressedBits = 0 , len = chars.length ;
        if ( len < 2 ) return len ;
        char prevChar = chars[0] ;
        for ( int i = 0 , j ; i < len ; i++ ) {
            j = i ;
            while ( i < len && prevChar == chars[i] ) i++ ;
            chars[compressedBits++] = prevChar ;
            if ( i-j > 1 ) {
                int count = (i-j) ;
                long temp = 1 ;
                while ( count > 0 ) {
                    temp *= 10 ;
                    temp += count % 10 ;
                    count /= 10 ;
                }
                while ( temp > 1 ) {
                    chars[compressedBits++] = (char) ((temp%10)+'0') ;
                    temp /= 10 ;
                }
            }
            if ( i < len ) prevChar = chars[i] ;
            if ( i-j != 0 ) i-- ;
        }
        return compressedBits ;
    }
}