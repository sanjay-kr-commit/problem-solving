
class Solution {
    public void reorderList(ListNode head) {
        int len = 0 ;
        ListNode cur = head;
        while ( cur != null ) {
            len++;
            cur = cur.next;
        }
        int skip = len / 2;
        skip-- ;
        cur = head ;
        while ( skip > 0 ) {
            cur = cur.next;
            skip--;
        }
        ListNode tail = cur ;
        ListNode newHead = cur.next;
        tail.next = null ;
        ListNode prev = null , temp ;
        cur = newHead ;
        while ( cur != null ) {
            temp = cur.next ;
            cur.next = prev;
            prev = cur ;
            cur = temp ;
        }
        newHead = prev ;
        cur = head ;
        while ( cur != null ) {
            temp = cur.next ;
            cur.next = newHead ;
            prev = cur ;
            cur = cur.next ;
            newHead = temp ;
        }
        if ( newHead!= null ) prev.next = newHead ;
    }
}
