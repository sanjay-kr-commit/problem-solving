class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        if (word1.equals(word2)) return true;

        int[] freq1 = new int['z' + 1];
        int[] freq2 = new int['z' + 1];

        for ( char c : word1.toCharArray() ) freq1[c]++;
        for ( char c : word2.toCharArray() ) freq2[c]++;

        for (int i = 'a'; i <= 'z'; i++)
            if (freq1[i] == 0 ^ freq2[i] == 0)
                return false;

        // sort count
        freq1['a' - 1] = -1;
        for ( int i , k = 'a' ; k <= 'z'; k++ ) {
            int f1i = freq1[i = k];
            while (f1i < freq1[--i])
                freq1[i + 1] = freq1[i];
            freq1[i + 1] = f1i;
        }

        // sort count
        freq2['a' - 1] = -1;
        for ( int i , k = 'a' ; k <= 'z'; k++ ) {
            int f2i = freq2[i = k];
            while (f2i < freq2[--i])
                freq2[i + 1] = freq2[i];
            freq2[i + 1] = f2i;
        }

        boolean result = true;

        for (int i = 'a'; result && i <= 'z'; i++)
            result = freq1[i] == freq2[i] ;

        return result;
    }
}