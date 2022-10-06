// took 0 ms
/*I hope this explanation will be helpful
 * when we start going up the stairs 
 * on every step we have two one
 * either to take one step or two step
 * if you have studied tree you'll notice 
 * it working like a tree
 * where your current stair act as a parent node
 * and two step acting as child node
 * 
 * for example if we have to go up 3 stairs
 * the tree would look something like this
 *        0
 *     1     2
 *   2   3  3  4
 * 3   4
 * 
 * there are only three way we could go up stairs
 * 
 * there are few thing we noticed
 * 1. every two parent node with same value have same subtree i.e. they are being repeated
 * 
 * now lets look at no of ways on each unique node
 * 
 * stairs 3 2 1 0 
 * ways   1 1 2 3
 * 
 * we can clearly 
 * every possibily of cureent stair is sum of next two stairs
 * 
 * in short we can find unique ways by finding Fibonacci number of stair count
*/
class Solution {
    public int climbStairs(int n) {
        int one = 1 , two = 1 ;
        for ( int i = 0 ; i < n -1 ; i++ ) {
            one += two ;
            two = one - two ;
        }
        return one ;
    }
}