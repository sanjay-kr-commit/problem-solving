class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0 , head);
        ListNode curr = dummy;
        while ( curr != null ) {
            ListNode next = curr.next ;
            ListNode subHead = next ;
            for ( int i = 1 ; i < k && next != null ; i++ ) {
                next = next.next;
            }
            if ( next == null ) break;
            ListNode tail = next.next;
            next.next = null ;
            curr.next = reverse(subHead) ;
            while ( curr.next != null ) curr = curr.next;
            curr.next = tail ;
        }
        return dummy.next ;
    }

    ListNode reverse( ListNode head) {
        ListNode prev = null ;
        ListNode curr = head ;
        while ( curr != null ) {
            ListNode next = curr.next;
            curr.next = prev ;
            prev = curr ;
            curr = next;
        }
        return prev ;
    }

}