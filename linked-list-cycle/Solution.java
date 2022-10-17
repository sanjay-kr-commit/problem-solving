import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 16 ms
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> set = new HashSet<>() ;
        ListNode node = head ;
        while ( node != null ) {
            int hash = node.hashCode() ;
            if ( set.contains( hash ) ) return true ;
            else set.add(hash) ;
            node = node.next ;
        }
        return false ;
    }
}

//Floyd’s Cycle-Finding Algorithm // fast slow approach // 2 pointers // "tortoise and the hare algorithm"
// 0ms
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head , slow = head ;
        while ( fast != null && fast.next != null ) {
            if ( fast == slow ) return true ;
            fast = fast.next.next ;
            slow = slow.next ;
        }
        return false ;       
    }
}