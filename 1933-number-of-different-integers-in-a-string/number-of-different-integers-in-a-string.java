import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        StringBuffer buffer = new StringBuffer(word);
        for ( int i = 0 ; i < word.length() ; i++ ) if ( !Character.isDigit(word.charAt(i)) ) buffer.setCharAt(i, ' ');
        String[] nums = buffer.toString().split(" ");
        Set<String> st = new HashSet<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if (!nums[i].trim().isEmpty()) {
                StringBuffer sb2 = new StringBuffer(nums[i].trim());
                int j =0;
                while (sb2.length() > 0) {
                    char ch = sb2.charAt(j);
                    if (ch != '0') break;
                    sb2.deleteCharAt(j);
                }
                st.add(sb2.toString());
            }
        }
        return st.size();
    }
}