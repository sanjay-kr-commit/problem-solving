class Solution {
    public String countAndSay(int n) {
        if ( n == 1 ) return "1" ;
        String say = "1" ;
        for ( int k = 1 ; k < n ; k++ ) {
            StringBuilder countedString = new StringBuilder() ;
            int i = 0 , j = 0 ;
            while ( i < say.length() ) {
                while ( j < say.length() && say.charAt(i) == say.charAt(j) ) j++ ;
                countedString.append(j-i).append(say.charAt(i));
                i = j ;
            }
            say = countedString.toString() ;
        }
        return say ;
    }
}