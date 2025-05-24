struct ListNode {
  int val;
  struct ListNode *next;
};

// @leet start
#include <stdlib.h>
struct ListNode *swapPairs(struct ListNode *head) {
  struct ListNode *fakeHead = malloc(sizeof(struct ListNode));
  fakeHead->next = head;
  struct ListNode *curr = fakeHead, *temp;
  while (curr->next != NULL && curr->next->next != NULL) {
    temp = curr->next;
    curr->next = temp->next;
    temp->next = curr->next->next;
    curr->next->next = temp;
    curr = temp;
  }
  return fakeHead->next;
}
// @leet end
