class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode prev = null ;
        while ( l1 != null && l2 != null ) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10 ;
            l1.val = sum % 10 ;
            prev = l1 ;
            l1 = l1.next ;
            l2 = l2.next ;
        }
        ListNode curr = l1 == null ? l2 : l1 ;
        if ( prev != null ) prev.next = curr;
        while ( carry > 0 && curr != null ) {
            int sum = carry + curr.val ;
            curr.val = sum % 10 ;
            carry = sum / 10 ;
            prev = curr ;
            curr = curr.next ;
        }
        if ( prev != null && carry > 0 ) {
            prev.next = new ListNode(carry);
        }
        return head ;
    }
}
