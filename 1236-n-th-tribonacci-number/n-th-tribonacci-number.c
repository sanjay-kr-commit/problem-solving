int tribonacci(int n) {
  if ( n < 2 ) return n ;
  int a = 0 , b = 1 , c = 1 , t ;
  for ( int i = 2 ; i < n ; i++ ) {
    t = a + b + c ;
    a = b ;
    b = c ;
    c = t ;
  }
  return c ;
}
