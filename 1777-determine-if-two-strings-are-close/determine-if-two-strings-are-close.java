class Solution {
    public boolean closeStrings(String word1, String word2) {
        if ( word1.length() != word2.length() ) return false;
        int [] map1 = new int[26] ,
               map2 = new int[26];
        int min = 0 , max = 0 ;
        for ( int i = 0 ; i < word1.length() ; i++ ) {
            int j = ++map1[word1.charAt(i) - 'a'];
            int k = ++map2[word2.charAt(i) - 'a'];
            min = Math.min(min, Math.min( j , k ));
            max = Math.max(max, Math.max( j , k ));
        }
        for ( int i = 0 ; i < 26 ; i++ ) {
            if ( map1[i] == 0 ^ map2[i] == 0 ) return false;
        }
        int [] freq1 = new int[max - min + 1] ,
               freq2 = new int[max - min + 1];
        for ( int i : map1 ) freq1[i-min]++ ;
        for ( int i : map2 ) freq2[i-min]++ ;
        for ( int i = 0 ; i< freq1.length ; i++ ) {
            if ( freq1[i] != freq2[i] ) return false;
        }
        return true;
    }

    boolean containsSameCharacters(String word1, String word2) {
        int word1Mask = 0 , word2Mask = 0 ;
        for ( int i = 0 ; i < word1.length() ; i++ ) {
            word1Mask |= 1 << word1.charAt(i)-'a' ;
            word2Mask |= 1 << word2.charAt(i)-'a' ;
        }
        return word1Mask == word2Mask;
    }

}