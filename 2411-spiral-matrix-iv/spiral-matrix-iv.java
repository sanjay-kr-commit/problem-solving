/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] matrix = new int[m][n];
        for ( int i = 0 ; i < m ; i++ ) for ( int j = 0 ; j < n ; j++ ) matrix[i][j] = -1 ;
        int x = 0 , y = 1 , i = 0 , j = 0 ,
                direction = 0 , offX = 0 , offY = 0 , mm = m , nn = n;
        ListNode cur = head ;
        while ( cur != null ) {
            matrix[offX+i][offY+j] = cur.val ;
            if ( i == 0 && j == n-1 && direction == 0 ) {
                direction++ ; x++ ; y-- ;
            } else if ( i == m-1 && j == n-1 && direction == 1 ) {
                direction++ ; x-- ; y-- ;
            } else if ( i == m-1 && j == 0 && direction == 2 ) {
                direction++ ; x-- ; y++ ;
            } else if ( i == 1 && j == 0 && direction == 3 ) {
                direction = 0 ; x++ ; y++ ; m -= 2 ; n -= 2 ;
                offX++ ; offY++ ; i -= x+1 ; j -= y ;
            }
            i += x ;
            j += y ;
            cur = cur.next;
        }
        return matrix ;
    }

}