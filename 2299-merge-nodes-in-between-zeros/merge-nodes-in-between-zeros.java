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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(0) ,
                node = dummyHead ,
                temp = head ;
        int sum = 0 ;
        if ( temp != null ) temp = temp.next ;
        while ( temp != null ) {
            if ( temp.val == 0 ) {
                node.next = new ListNode( sum ) ;
                node = node.next ;
                sum = 0 ;
            } else sum += temp.val ;
            temp = temp.next ;
        }
        return dummyHead.next ;
    }
}