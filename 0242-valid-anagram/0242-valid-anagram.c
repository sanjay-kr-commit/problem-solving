bool isAnagram(char *s, char *t) {
  int sl = 0, tl = 0;
  while (s[sl] != '\0')
    sl++;
  while (t[tl] != '\0')
    tl++;
  if (sl != tl)
    return false;
  int freq[128];
  for (int i = 0; i < 128; i++)
    freq[i] = 0;
  for (int i = 0; i < sl; i++) {
    freq[s[i]]++;
    freq[t[i]]--;
  }
  for ( int i = 0 ; i < 128 ; i++ ) if ( freq[i] != 0 ) return false ;
  return true;
}