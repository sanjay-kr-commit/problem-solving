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
// 11 ms
class Solution1 {
    public boolean isPalindrome(ListNode head) {
        // check if the list is smaller than 2
        if ( head == null || head.next == null ) return true ;
        int size = 0 ;
        ListNode temp = head ;
        // get size of list
        while ( temp != null ) {
            size++ ;
            temp = temp.next ;
        }
        temp = head ;
        ListNode backup = null ;
        ListNode reverse = null ;
        // get tp the mid of list
        for ( int i = 0 ; i < size/2 ; i++ ) temp = temp.next ;
        // skip middle element if list size is odd
        if ( size % 2 == 1 ) temp = temp.next ;
        // reverse the rest half of list and store it in reverse variable
        for ( int i = 0 ; i < size/2 ; i++ ) {
            backup = temp ;
            temp = temp.next ;
            backup.next = reverse ;
            reverse = backup ;
        }
        // cross check each element
        for ( int i = 0 ; i < size/2 ; i++ ) {
            if ( head.val != reverse.val ) return false ;
            head = head.next ;
            reverse = reverse.next ;
        }
        // if every element matched return true
        return true ;
    }
}

// 13ms
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head , slow = head , prev = null ;
        // reversing the first half
        while ( fast != null && fast.next != null ) {
            fast = fast.next.next ;
            ListNode temp = slow ;
            slow = slow.next ;
            temp.next = prev ;
            prev = temp ;
        }
        // if list size is odd then skipping the middle element
        if ( fast != null ) {
            slow = slow.next ;
        }
        // comparing the reversed first half stored in pre and second half pointer present in slow
        while ( prev != null && slow != null ) {
            // if value mismatched return false
            if ( prev.val != slow.val ) return false ;
            prev = prev.next ;
            slow = slow.next ;
        }
        // checking if both half was of same size
        return prev == null && slow == null ;
    }
}