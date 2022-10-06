class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null ) return head ;
        ListNode node = head ;
        while ( node != null ) {
            if ( node.next != null && node.val == node.next.val ) node.next = node.next.next ;
            else node = node.next ;
        }
        return head ;       
    }
}