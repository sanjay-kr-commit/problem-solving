class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0) , prev , curr , next , tmp ;
        dummy.next = head ;
        prev = dummy ;
        curr = prev.next ;
        boolean remove ;
        while(curr != null) {
            remove = false ;
            next = curr.next ;
            while( next != null && curr.val == next.val ) {
                remove = true ;
                next = next.next ;
            }
            if ( remove ) {
                prev.next = next ;
                curr = next ;
            } else {
                prev = prev.next ;
                curr = prev.next ;
            }
        }
        return dummy.next ;
    }
}