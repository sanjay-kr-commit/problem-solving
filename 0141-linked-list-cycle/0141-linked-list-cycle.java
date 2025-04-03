class Solution {
  public boolean hasCycle(ListNode head) {
    if ( head == null ) return false ;
    ListNode slow = head , fast = head.next;
    while ( fast != null && slow != null ) {
      slow = slow.next;
      fast = fast.next;
      if ( fast != null ) fast = fast.next;
      if ( slow == fast ) return true;
    }
    return false ;
  }
}
