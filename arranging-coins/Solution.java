class Solution {
    public int arrangeCoins(int n) {
       long l = 0 , r = n , k , c ;
       while ( l <= r ) {
         k = l + ( r - l ) / 2 ;
         c = k * ( k + 1 ) / 2 ;
         if ( c == n ) return (int)k ;
         if ( c < n ) l = k + 1 ;
         else r = k - 1;
       }
       return (int)r ;
    }
}
