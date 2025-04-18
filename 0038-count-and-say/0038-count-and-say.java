class Solution {
    public String countAndSay(int n) {
        if ( n == 1 ) return "1" ;
        String say = countAndSay( n-1 ) ;
        StringBuilder compressedString = new StringBuilder() ;
        // compress the string
        int i = 0 , j = 0 ;
        while ( i < say.length() ) {
            while ( j < say.length() && say.charAt(j) == say.charAt(i) ) j++ ;
            compressedString.append(j-i).append(say.charAt(i)) ;
            i = j ;
        }
        // compression complete
        return compressedString.toString() ;
    }
}