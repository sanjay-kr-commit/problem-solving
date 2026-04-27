class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        
        int[] prev = new int[n];
        int[] next = new int[n];
        
        int[] lastSeen = new int[26];
        
        for (int i = 0; i < 26; i++) 
            lastSeen[i] = -1;
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            prev[i] = lastSeen[c];
            lastSeen[c] = i;
        }
        
        for (int i = 0; i < 26; i++) 
            lastSeen[i] = n;
        
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A';
            next[i] = lastSeen[c];
            lastSeen[c] = i;
        }
        
        long result = 0;
        
        for (int i = 0; i < n; i++) {
            result += (long)(i - prev[i]) * (next[i] - i);
        }
        
        return (int) result;
    }
}