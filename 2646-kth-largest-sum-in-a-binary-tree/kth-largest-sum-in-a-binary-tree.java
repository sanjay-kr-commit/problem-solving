import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// let's just implement a stack
class Solution {
    TreeNode [] stack ;
    public long kthLargestLevelSum(TreeNode root, int k) {
        stack = new TreeNode[34500];
        final int rightStart = stack.length-1 ;
        // divide stack into two parts
        int leftIndex = 0 , rightIndex = rightStart ;
        // add first element to stack
        stack[leftIndex++] = root ;
        long lowestValue = Long.MIN_VALUE ;
        PriorityQueue<Long> pq = new PriorityQueue<>( Math.min( 100 , k ) ) ;
        while ( true ) {
            long sum = 0 ;
            // stack is empty
            if ( leftIndex == 0 ) break;
            while ( leftIndex != 0 ) {
                // empty first level
                sum += stack[--leftIndex].val ;
                // populate second level
                if ( stack[leftIndex].left != null ) stack[rightIndex--] = stack[leftIndex].left ;
                if ( stack[leftIndex].right != null ) stack[rightIndex--] = stack[leftIndex].right ;
            }
            if ( sum > lowestValue ) {
                pq.add(sum) ;
                if ( pq.size() > k ) {
                    pq.remove() ;
                    lowestValue = pq.peek() ;
                }
            }
            sum = 0 ;
            // stack is empty
            if ( rightIndex == rightStart ) break;
            while ( rightIndex != rightStart ) {
                // empty second level
                sum += stack[++rightIndex].val ;
                // populate first level
                if ( stack[rightIndex].left != null ) stack[leftIndex++] = stack[rightIndex].left ;
                if ( stack[rightIndex].right != null ) stack[leftIndex++] = stack[rightIndex].right ;
            }
            if ( sum > lowestValue ) {
                pq.add(sum) ;
                if ( pq.size() > k ) {
                    pq.remove() ;
                    lowestValue = pq.peek() ;
                }
            }
        }
        return ( pq.size() < k ) ? -1 : pq.peek() ;
    }
}