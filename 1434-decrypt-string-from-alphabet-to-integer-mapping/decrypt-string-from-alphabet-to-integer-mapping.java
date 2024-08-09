class Solution {
    public String freqAlphabets(String s) {
        char[] buffer = new char[s.length()];
        int len = buffer.length-1;
        for ( int i = s.length()-1 , index = 0 ; i > -1 ; i--  ) {
            if ( s.charAt( i ) == '#' ) {
                buffer[len--] = (char)((((s.charAt( i-2 )-'0')*10)+((s.charAt(i-1)-'0')))+'a'-1);
                i -= 2 ;
            } else {
                while ( i > -1 && s.charAt( i ) != '#' ) buffer[len--] = (char) ( s.charAt(i--)-'0'+'a'-1);
                i++ ;
            }
        }
        return new String( buffer , len+1 , buffer.length-len-1) ;
    }
}