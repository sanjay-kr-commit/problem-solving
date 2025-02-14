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
  public int[] nextLargerNodes(ListNode head) {
    ListNode prev = null , cur = head ;
    int size = 0 ;
    while (cur != null) {
      ListNode next = cur.next ;
      cur.next = prev ;
      prev = cur ;
      cur = next ;
      size++ ; 
    }
    int [] stack = new int [size] ,
           result = new int [size] ;
    int stackPointer = -1 ;
    int res = size-1 ;
    while ( prev != null ) {
      int num = prev.val ;
      while ( stackPointer > -1 && stack[stackPointer] <= num ) stackPointer-- ;
      if ( stackPointer != -1 ) result[res--] = stack[stackPointer] ;
      else res-- ;
      stack[++stackPointer] = num ;
      prev = prev.next ;
    }
    return result ;
  }
}
