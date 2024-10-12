import java.util.Stack;

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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while ( cur != null ) {
            stack.add( cur ) ;
            cur = cur.next ;
        }
        ListNode newHead = (stack.empty()) ? null : stack.pop() ;
        cur = newHead ;
        while ( !stack.empty() ) {
            cur.next = stack.pop() ;
            cur = cur.next ;
        }
        if ( cur != null ) cur.next = null ;
        return newHead ;
    }
}