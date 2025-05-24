// @leet start
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdlib.h>
int *findWordsContaining(char **words, int wordsSize, char x, int *returnSize) {
  int size = 0, *indices = malloc(sizeof(int) * wordsSize);

  for (int i = 0; i < wordsSize; i++) {

    int index = 0, str = 0, hash = 1 << (x - 'a');

    while (words[i][index] != NULL) {
      str |= 1 << (words[i][index++] - 'a');
    }

    if ((str & hash) == hash)
      indices[size++] = i;
  }

  *returnSize = size;
  return indices;
}
// @leet end
