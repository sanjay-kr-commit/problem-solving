// @leet start
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdlib.h>
int *findWordsContaining(char **words, int wordsSize, char x, int *returnSize) {
  int rs = 0;
  int *result = malloc(sizeof(int) * (wordsSize));
  for (int i = 0; i < wordsSize; i++) {
    int j = 0;
    while (words[i][j] != NULL) {
      if (words[i][j] == x) {
        result[rs++] = i;
        break;
      }
      j++;
    }
  }
  *returnSize = rs;
  return result;
}
// @leet end
