// string are immutable in java using string result 
// in bad runtime because the addition of character will
// take linear time
// while string builder take constant time
// 0 ms
class Solution {
    public String convertToTitle(int n) {
      StringBuilder result = new StringBuilder() ;
       
       while(n > 0) {
           n --;
           result.append( (char)('A' + (n % 26)) ) ;
           n = n / 26;
       }
       return result.reverse().toString();
    }
}