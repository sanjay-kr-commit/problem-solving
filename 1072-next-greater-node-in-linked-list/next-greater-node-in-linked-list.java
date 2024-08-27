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
        ListNode prev = null;
        ListNode current = head;
        int size = 0;
        while ( current != null ) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            size++;
        }
        int[] stack = new int[size] ,
              result = new int[size];
        int top = -1;
        ListNode reversedHead = prev;
        for (int i = size - 1; i >= 0; i--) {
            int currentValue = reversedHead.val;
            while (top >= 0 && stack[top] <= currentValue) top--;
            result[i] = ( top == -1 ) ? 0 : stack[top];
            stack[++top] = currentValue;
            reversedHead = reversedHead.next;
        }

        return result;
    }
}