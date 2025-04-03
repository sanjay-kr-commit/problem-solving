class Solution {
  public int[] plusOne(int[] digits) {
    boolean nine = true ;
    for ( int digit : digits ) nine &= digit == 9 ;
    if ( nine ) {
      int [] sum = new int [ digits.length + ( nine ? 1 : 0 ) ];
      sum[0] = 1 ;
      return sum ;
    }
    else {
      int rem = 1 ;
      for ( int i = digits.length-1 ; rem > 0 && i > -1 ; i-- ) {
        digits[i] += rem ;
        if ( digits[i] < 10 ) rem = 0 ;
        else digits[i] = 0 ;
      }
    }
    return digits;
  }
}
