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
    public ListNode deleteMiddle(ListNode head) {
        int size = 0 ;
        ListNode curr = head ;
        while ( curr != null ) {
            size++ ;
            curr = curr.next;
        }
        if ( size < 2 ) return null ;
        curr = head ;
        for ( int i = 0 , len = (size/2)-1 ; i < len ; i++ ) {
            curr = curr.next;
        }
        curr.next = curr.next.next ;
        return head ;
    }
}