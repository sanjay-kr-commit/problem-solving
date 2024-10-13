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
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head ;
        int size = 0 ;
        while ( curr != null ) {
            size++ ;
            curr = curr.next ;
        }
        ListNode[] array = new ListNode[size];
        int l = 0 , r = size - 1 ;
        curr = head ;
        boolean odd = true ;
        while ( curr != null ) {
            array[ (odd) ? l : r ] = curr ;
            curr = curr.next ;
            array[ (odd) ? l++ : r-- ].next = null ;
            odd = !odd ;
        }
        ListNode pseudoHead = new ListNode(-1) ;
        curr = pseudoHead ;
        int i = 0 ;
        while ( i < l ) {
            curr.next = array[i++] ;
            curr = curr.next ;
        }
        i = size-1 ;
        while ( i > r ) {
            curr.next = array[i--] ;
            curr = curr.next ;
        }
        return pseudoHead.next ;
    }
}