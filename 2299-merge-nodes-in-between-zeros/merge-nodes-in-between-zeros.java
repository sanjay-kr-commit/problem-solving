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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head;
        // ListNode pre = new ListNode(-1);
        //pre.next = node;
        ListNode pre = null;
        while(node.next != null){
            if(node.val == 0){
                ListNode curr = node;
                int sum = 0;
                node = node.next;
                while(node != null && node.val != 0){
                    sum = sum + node.val;
                    node = node.next;
                }
                curr.val = sum;
                pre = curr;
                curr.next = node;
            }
        }
        pre.next = null;
        return head;
    }
}