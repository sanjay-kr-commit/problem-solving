class Solution {
  public boolean checkPerfectNumber(int num) {
    if ( num <= 1 ) return false ;
    int sum = 1 ;
    for ( int i = num/2 ; i > 1 ; i-- ) {
      if ( num % i == 0 ) sum += i ;
      if ( sum > num ) return false ;
    }
    return sum == num ;
  }
}

// constant time 
class Solution2 {
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
