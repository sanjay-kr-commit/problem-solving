class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ( str1.length() < str2.length() ) return gcdOfStrings(str2, str1);
        int i , j , m = str1.length() , n = str2.length() ;
        for ( i = 0 , j = 0 ; i < m ; i++ , j++ ) {
            if ( str1.charAt(i) != str2.charAt(j%n) ) break;
        }
        if ( i != m ) return "" ;
        n = gcd( m , n ) ;
        while ( n > 0 ) if ( m%n != 0 ) n-- ;
        else {
            for ( i = 0 , j = 0 ; i < m ; i++ , j++ ) {
                if ( str1.charAt(i) != str2.charAt(j%n) ) break ;
            }
            if ( i == m && m % n == 0 ) break ;
            else n-- ;
        }
        return str2.substring( 0 , n ) ;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

}