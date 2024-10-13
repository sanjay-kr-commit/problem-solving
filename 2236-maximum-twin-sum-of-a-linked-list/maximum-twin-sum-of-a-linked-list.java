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
    public int pairSum(ListNode head) {
        int size = 0 , mid , ptr = 0 , max = Integer.MIN_VALUE ;
        ListNode cur = head;
        while ( cur != null ) {
            size++ ;
            cur = cur.next;
        }
        if ( size == 0 ) return size ;
        mid = size/2 ;
        ListNode [] stack = new ListNode[mid] ;
        cur = head ;
        while ( ptr < mid ) {
            stack[ptr++] = cur ;
            cur = cur.next;
        }
        if ( size % 2 == 1 ) {
            max = Math.max( max , cur.val ) ;
            cur = cur.next ;
            
        }
        while ( cur != null && ptr > 0 ) {
            max = Math.max( max , cur.val + stack[--ptr].val ) ;
            cur = cur.next ;
        }
        return max ;
    }
}