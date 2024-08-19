class Solution {
    public int maxProduct(String[] words) {
        int product = 0 ;
        for ( int i = 0 ; i < words.length ; i++ ) {
            boolean [] exist = new boolean[128] ;
            for ( int j = 0 ; j < words[i].length() ; j++ ) exist[words[i].charAt(j)] = true;
            outer:
            for ( int j = 0 ; j < words.length ; j++ ) {
                if ( i == j ) continue;
                for ( int k = 0 ; k < words[j].length() ; k++ ) {
                    if ( exist[words[j].charAt(k)] ) continue outer;
                }
                if ( words[i].length() * words[j].length() > product ) product = words[i].length() * words[j].length();
            }
        }
        return product ;
    }
}