class Solution {
    public String makeSmallestPalindrome(String s) {
        char [] buffer = new char[s.length()];
        for ( int i = 0 ; i < s.length() ; i++ ) buffer[i] = s.charAt(i);
        for ( int i = 0 , j = buffer.length-1 ; i < j ; i++ , j-- ) {
            if ( buffer[i] > buffer[j] ) buffer[i] = buffer[j];
            else if ( buffer[j] > buffer[i] ) buffer[j] = buffer[i];
        }
        return new String(buffer);
    }
}