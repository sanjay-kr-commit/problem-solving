// @leet start
class Solution {

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, s.length(), p.length());
    }

    private boolean isMatch(String s, String p, int indexS, int indexP, int lenS, int lenP) {
        while (indexS < lenS && indexP < lenP) {
            if ( ( s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.' ) && ( indexP+1 == lenP || p.charAt(indexP+1) != '*' ) ) {
                indexP++ ;
                indexS++ ;
                continue;
            }
           
        }
        while (indexP < lenP) {
            if (p.charAt(indexP) == '*') indexP++;
            else if (indexP + 1 < lenP && p.charAt(indexP + 1) == '*') indexP += 2;
            else break;
        }
        return lenS == indexS && lenP == indexP;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("ba", ".*a*a"));
        System.out.println(s.isMatch("bbbba", ".*a*a"));
        System.out.println(s.isMatch("aab", "c*a*b*"));
        System.out.println(s.isMatch("ab", ".*"));
        System.out.println(!s.isMatch("aab", "b.*"));
        System.out.println(!s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "a*"));
    }

}
// @leet end
