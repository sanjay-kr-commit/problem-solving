import java.util.ArrayList;
import java.util.List;

class Solution {

    int [][] map = new int[8][3] ;

    Solution() {
        map[0] = new int[] { 'a' , 'b' , 'c' };
        map[1] = new int[] { 'd' , 'e' , 'f' };
        map[2] = new int[] { 'g' , 'h' , 'i' };
        map[3] = new int[] { 'j' , 'k' , 'l' };
        map[4] = new int[] { 'm' , 'n' , 'o' };
        map[5] = new int[] { 'p' , 'q' , 'r' , 's' };
        map[6] = new int[] { 't' , 'u' , 'v' };
        map[7] = new int[] { 'w' , 'x' , 'y' , 'z' };
    }

    public List<String> letterCombinations(String digits) {
        int size = 1 ;
        char [] chars = digits.toCharArray();
        for ( char c : chars ) size *= map[c-'2'].length ;
        ArrayList<String> combinations = new ArrayList<>( size ) ;
        calculatePermutation( chars , 0 , combinations , new StringBuilder( digits.length() ) );
        return combinations ;
    }

    void calculatePermutation( char [] digits , int index , List<String> combinations , StringBuilder buffer ) {
        if ( index == digits.length ) return;
        boolean isLast = index == digits.length - 1 ;
        for ( int c : map[digits[index]-'2'] ) {
            buffer.append( (char)c );
            if ( isLast ) combinations.add( buffer.toString() ) ;
            else calculatePermutation( digits , index + 1 , combinations , buffer ) ;
            buffer.deleteCharAt( buffer.length()-1 );
        }
    }




}