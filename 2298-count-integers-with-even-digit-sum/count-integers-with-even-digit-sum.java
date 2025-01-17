class Solution {
  public int countEven(int num) {
    int count = 0 , sum , temp ;
    for ( int i = 1 , len = num +1 ; i < len ; i++ ) {
      sum = 0 ;
      temp = i ;
      while (temp > 0 ) {
        sum += temp % 10 ;
        temp /= 10 ;
      }
      count += (sum+1)%2; 
    }
    return count ;
  }
}
