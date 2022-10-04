// 1ms
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1 , size = 0 ;
        while ( i > -1 && s.charAt(i) == ' ' ) i-- ;
        while ( i > -1 && s.charAt(i--) != ' ' ) size++ ;
        return size ;
    }
}