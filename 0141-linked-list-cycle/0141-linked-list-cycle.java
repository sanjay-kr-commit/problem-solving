class Solution {
  public boolean hasCycle(ListNode head) {
    if ( head == null ) return false ;
    ListNode slow = head , fast = head.next;
    while ( fast != null && fast.next != null ) {
      slow = slow.next;
      fast = fast.next.next;
      if ( slow == fast ) return true;
    }
    return false ;
  }
}
