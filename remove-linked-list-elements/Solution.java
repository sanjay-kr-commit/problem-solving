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
// 5ms
class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        if ( head == null ) return null ;
        while ( head != null && head.val == val ) head = head.next ;
        if ( head == null ) return null ;
        ListNode node = head ;
        while ( node.next != null ) {
            if ( node.next.val == val ) node.next = node.next.next ;
            else node = node.next ;
        }
        return head ;
    }
}

// 1ms
class Solution {
    public ListNode removeElements( ListNode head , int val ) {
        head = new ListNode( -1 , head ) ;
        ListNode node = head ;
        while ( node.next != null ) {
            if ( node.next.val == val ) node.next = node.next.next ;
            else node = node.next ;
        }
        return head.next ;
    }
}