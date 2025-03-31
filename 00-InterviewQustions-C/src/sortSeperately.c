#include <stdio.h>
#include <string.h>

char *sort(char *ans) {
  int len = strlen(ans);
  for (int i = 0; i < len; i++) {
    if (ans[i] > 'Z' || ans[i] < 'A')
      continue;
    for (int j = i + 1; j < len; j++) {
      if (ans[j] > 'Z' || ans[j] < 'A')
        continue;
      if (ans[i] > ans[j]) {
        char t = ans[i];
        ans[i] = ans[j];
        ans[j] = t;
      }
    }
  }
  for (int i = 0; i < len; i++) {
    if (ans[i] > 'z' || ans[i] < 'a')
      continue;
    for (int j = i + 1; j < len; j++) {
      if (ans[j] > 'z' || ans[j] < 'a')
        continue;
      if (ans[i] > ans[j]) {
        char t = ans[i];
        ans[i] = ans[j];
        ans[j] = t;
      }
    }
  }
  return ans;
}

int main() {
  char str1[] = "defRTSersUXI";
  char ans1[] = "deeIRSfrsTUX";
  printf("%s\n", str1);
  printf("%s\n", sort(str1));
  printf("%s\n", ans1);
  return 0;
}
