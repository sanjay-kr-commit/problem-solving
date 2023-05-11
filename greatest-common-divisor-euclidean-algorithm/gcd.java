class gcd {
  public static int gcd( int num1 , int num2 ) {
    if ( num1 < num2 ) return gcd( num2 , num1 ) ;
    int rem = num1 % num2 ;
    return ( rem == 0 ) ? num2 : gcd( num2 , rem ) ;
  }
}
