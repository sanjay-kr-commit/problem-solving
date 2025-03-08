class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for ( int i = 0 ; i < words.length ; i++ ) {
            outer :
            for ( int j = i+1 ; j < words.length ; j++ ) {
                if ( words[i].length() > words[j].length() ) continue;
                for ( int k = 0 , l = words[i].length()-1 , ll = words[j].length()-1 ; k < words[i].length() ; k++ , l-- , ll-- ) {
                    if (
                            (words[j].charAt(k) != words[i].charAt(k)) ||
                                    (words[i].charAt(l) != words[j].charAt(ll))
                    ) continue outer;
                }
                count++ ;
            }
        }
        return count;
    }
}