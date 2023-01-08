/*
 *Why divide i by two when we'll multiply it by two 
 *Because by diving it i will always have even num
 * for ex :
 *  (5/2) = 2 *2 = 4
 *  while 
 *  (4/2) = 2 * 2 = 4
 * */
class Solution {
    public int longestPalindrome(String s) {
       int[] count = new int[128] ;
       for ( int i = 0 ; i < s.length() ; i++ ) {
         count[s.charAt(i)]++ ;
       }
       int maxLen = 0 ;
       for ( int i : count ) {
         maxLen += i / 2 * 2 ;
         if ( maxLen % 2 == 0 && i % 2 == 1 ) maxLen++ ;
       }
       return maxLen ;
    }
}
