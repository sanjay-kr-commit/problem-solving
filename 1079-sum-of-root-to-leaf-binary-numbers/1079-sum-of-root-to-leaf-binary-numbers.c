/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#include <stdio.h>
int sum = 0;
void sumRoot(struct TreeNode *node, int num) {
  if (node == NULL) {
    return;
  }
  num = (num << 1) | node->val;
  if (node->left == NULL && node->right == NULL) {
    sum += num;
    return;
  }
  sumRoot(node->left, num);
  sumRoot(node->right, num);
}
int sumRootToLeaf(struct TreeNode *root) {
  sum = 0;
  sumRoot(root, 0);
  return sum;
}