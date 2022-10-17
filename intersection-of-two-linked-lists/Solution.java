import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // 12 ms
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<Integer> hash = new HashSet<>();       
        ListNode a = headA , b = headB ;
        while ( a != null && b != null ) {
            int hashA = a.hashCode() , hashB = b.hashCode() ;
            if ( hashA == hashB ) return a ;
            if ( hash.contains( hashA ) ) return a ;
            hash.add( hashA ) ;
            if ( hash.contains(hashB) ) return b ; 
            hash.add( hashB ) ;
            a = a.next ;
            b = b.next ;
        }
        while ( a != null ) {
            int hashA = a.hashCode() ;
            if ( hash.contains(hashA) ) return a;
            a = a.next ;
        }
        while ( b != null ) {
            int hashB = b.hashCode() ;
            if ( hash.contains(hashB) ) return b;
            b = b.next ;
        }
        return null ;
    }
}

// 748 ms
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA , b = null ;
        while ( a != null ) {
            b = headB ;
            while ( b != null ) {
                if ( b == a ) return b ;
                b = b.next ;
            }
            a = a.next ;
        }
        return null ;
    }
}

// 1ms
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iterator = headA ;
        int lenA = 0 , lenB = 0 ;
        while ( iterator != null ) {
            lenA++ ;
            iterator = iterator.next ;
        }
        iterator = headB ;
        while ( iterator != null ) {
            lenB++ ;
            iterator = iterator.next ;
        }
        while ( lenA > lenB ) {
            headA = headA.next ;
            lenA-- ;
        }
        while ( lenA < lenB ) {
            headB = headB.next ;
            lenB-- ;
        }
        while ( headA != null ) {
            if ( headA == headB ) return headA ;
            headA = headA.next ;
            headB = headB.next ;
        }
        return headA ;
    }
}