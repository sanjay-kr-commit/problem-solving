class Solution {
    public String makeSmallestPalindrome(String s) {
        char [] buffer = new char[s.length()];
        int i , j ;
        for ( i = 0 , j = buffer.length-1 ; i < j ; i++ , j-- ) {
            buffer[i] = s.charAt(i);
            buffer[j] = s.charAt(j);
            if ( buffer[i] > buffer[j] ) buffer[i] = buffer[j];
            else if ( buffer[j] > buffer[i] ) buffer[j] = buffer[i];
        }
        if ( i == j ) buffer[i] = s.charAt(j);
        return new String(buffer);
    }
}