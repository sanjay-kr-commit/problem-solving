
bool isAlpha(char c) {
  return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
         (c >= '0' && c <= '9');
}

char lower(char c) {
  if (c >= 'a' && c <= 'z' || (c >= '0' && c <= '9'))
    return c;
  return c + 32;
}

void trimLeft(char *s, int *l, int r) {
  while (*l < r && !isAlpha(s[*l]))
    *l += 1;
}

void trimRight(char *s, int l, int *r) {
  while (l < *r && !isAlpha(s[*r]))
    *r -= 1;
}

bool isPalindrome(char *s) {
  int l = 0, r = 0;
  while (s[r] != NULL || s[r] != '\0')
    r++;
  r--;
  trimLeft(s, &l, r);
  trimRight(s, l, &r);
  while (l < r) {
    if (lower(s[l]) != lower(s[r]))
      return false;
    l++;
    r--;
    trimLeft(s, &l, r);
    trimRight(s, l, &r);
  }
  return true;
}
