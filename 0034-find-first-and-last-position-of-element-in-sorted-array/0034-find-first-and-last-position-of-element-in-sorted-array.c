// @leet start
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <linux/limits.h>
#include <stdlib.h>
int search(int *nums, int x, int l, int r) {
  int m;
  while (l <= r) {
    m = l + (r - l) / 2;
    if (nums[m] == x)
      return m;
    else if (nums[m] > x)
      r = m - 1;
    else
      l = m + 1;
  }
  return -1;
}
int searchLeft(int *nums, int x, int l, int r) {
  int m;
  while (l < r) {
    m = l + (r - l) / 2;
    if (nums[m] != x)
      l = m + 1;
    else
      r = m - 1;
  }
  return (r > -1 && nums[r] == x) ? r : r + 1;
}
int searchRight(int *nums, int x, int l, int r) {
  int m;
  while (l < r) {
    m = l + (r - l) / 2;
    if (nums[m] != x)
      r = m - 1;
    else
      l = m + 1;
  }
  return (nums[l] != x) ? l - 1 : l;
}
int *searchRange(int *nums, int numsSize, int target, int *returnSize) {
  *returnSize = 2;
  int *arr = malloc(sizeof(int) * 2);
  arr[0] = -1;
  arr[1] = -1;
  int seed = search(nums, target, 0, numsSize - 1);
  if (seed == -1)
    return arr;
  arr[0] = searchLeft(nums, target, 0, seed);
  arr[1] = searchRight(nums, target, seed, numsSize - 1);
  return arr;
}
// @leet end
