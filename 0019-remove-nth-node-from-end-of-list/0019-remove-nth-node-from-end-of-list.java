class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0 ;
        ListNode cur = head;
        while ( cur != null ) {
            len++;
            cur = cur.next;
        }
        len -= n ;
        cur = dummy;
        while ( len > 0 ) {
            cur = cur.next;
            len-- ;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
