class Solution {
    public int minSteps(String s, String t) {
        int appendCount = 0 ;
        int [] freq = new int[26];
        for ( int i = 0, n = s.length() ; i < n ; i++ ) freq[s.charAt(i) - 'a']++;
        for ( int i = 0, n = t.length() ; i < n ; i++ ) freq[t.charAt(i) - 'a']--;
        for ( int i = 0 ; i < 26 ; i++ ) appendCount += Math.abs( freq[i] );
        return appendCount ;
    }
}