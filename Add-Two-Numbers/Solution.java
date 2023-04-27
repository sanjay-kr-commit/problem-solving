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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode
                parentNode = new ListNode() ,
                iterator = parentNode ;
        int carry = 0 ;
        while ( l1 != null || l2 != null ) {
            int temp1 = ( l1 != null ) ? l1.val : 0 ;
            int temp2 = ( l2 != null ) ? l2.val : 0 ;
            int sum = temp1 + temp2 + carry ;
            carry = sum / 10 ;
            iterator.next = new ListNode( sum % 10 ) ;
            iterator = iterator.next ;
            if ( l1 != null ) l1 = l1.next ;
            if ( l2 != null ) l2 = l2.next ;
        }
        while ( carry > 0 ) {
            iterator.next = new ListNode( carry%10 ) ;
            iterator = iterator.next ;
            carry /= 10 ;
        }
        return parentNode.next ;
    }
}