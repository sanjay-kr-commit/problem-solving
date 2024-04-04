class Solution {
    public int reverse(int x) {
        boolean sign = x < 0 ;
        int reverse = 0 ;
        int mod = (sign) ? -1 * x : x ;
        int len = 0 ;
        int limit = Integer.MAX_VALUE/10 ;
        while ( mod > 0 && len < 9 ) {
            reverse *= 10 ;
            reverse += mod % 10 ;
            mod /= 10 ;
            len++ ;
        }
        if ( len == 9 && mod > 0 ) {
            if ( reverse > limit ) return 0 ;
            if ( reverse == limit ) {
                if ( (sign && mod > 8) || (!sign && mod > 7 ) ) return 0 ;
            }
            reverse *= 10 ;
            reverse += mod ;
        }
        if ( sign ) reverse *= -1 ;
        return reverse ;
    }
}