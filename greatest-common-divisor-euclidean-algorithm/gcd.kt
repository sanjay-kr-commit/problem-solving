fun gcd( num1 : Int , num2 : Int ) : Int {
  if ( num1 < num2 ) return gcd( num2 , num1 ) 
  val rem : Int = num1 % num2 
  return if ( rem == 0 ) num2 
  else gcd( num2 , rem )
}

fun main() {
  println( gcd( 30 , 9 )) 
  println( gcd( 100 , 10 )) 
}
