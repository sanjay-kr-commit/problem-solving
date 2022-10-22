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
// 1ms
class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null , node = null ;
        while ( head != null ) {
            node = head ;
            head = head.next ;
            node.next = reversed ;
            reversed = node ;
        }
        return reversed ;
    }
}

// 0 ms
class Solution {
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) return head ;
        // recusively call reverseList till we reach the last node
        ListNode reversed = reverseList(head.next) ;
        // after last node had been reached 
        // assign it's next reference to next variable
        // which is gaurenteed not to be null by first line
        ListNode next = head.next ;
        // change the head reference to null
        head.next = null ;
        // assign the head variable to next
        // swapping the two variable
        next.next = head ;
        // return the swapped variable to previous
        // function call to do the same thing
        // until it reaches first call and the whole
        // list is reversed
        return reversed ;
    }
}