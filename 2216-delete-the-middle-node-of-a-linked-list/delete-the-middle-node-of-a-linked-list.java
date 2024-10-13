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
        deleteMiddle( head , 0 , (size/2)-1 ) ;
        return head ;
    }
    
    private void deleteMiddle( ListNode node , int index , int mid ) {
        if ( node == null || index > mid ) return;
        if ( index < mid ) {
            deleteMiddle( node.next , index+1 , mid ) ;
            return;
        }
        if ( node.next != null ) node.next = node.next.next;
    }
}