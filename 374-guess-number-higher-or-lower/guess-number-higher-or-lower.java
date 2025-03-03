/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1 , r = n , mid = -1 ;
        while ( guess(mid) != 0 ) {
            mid = l + ( r - l ) / 2 ;
            switch ( guess(mid) ) {
                case -1 : r = mid-1 ; break ;
                case 1 : l = mid+1 ; break ;
            }
        }
        return (guess(mid)==0)?mid:-1 ;
    }
}