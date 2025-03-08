class Solution {
    public int maxScore(String s) {
        int score = 0 , one = 0 , zero = 0 ;
        for ( char c : s.toCharArray() ) one += c-'0' ;
        for ( int i = 0 ; i < s.length()-1 ; i++) {
            if ( s.charAt( i ) - '0' == 1 ) one--;
            else zero++;
            score = Math.max(score, zero+one) ;
        }
        return score ;
    }
}