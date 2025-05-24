// @leet start

class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode fakeHead = new ListNode(0, head);
    ListNode curr = fakeHead;

    while (curr.next != null && curr.next.next != null) {
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = curr.next.next;
      curr.next.next = temp;
      curr = temp;
    }
    return fakeHead.next;
  }
}

// @leet end

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
