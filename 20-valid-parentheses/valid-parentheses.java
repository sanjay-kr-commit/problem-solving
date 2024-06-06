class Solution {
    public boolean isValid(String s) {
        char [] stack = new char[s.length()];
        int pointer = -1 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            if ( c == '(' || c == '{' || c == '[' ) stack[++pointer] = c ;
            else if ( pointer == -1 ) return false ;
            else if ( c == ')' && stack[pointer--] != '(' ) return false ;
            else if ( c == ']' && stack[pointer--] != '[' ) return false ;
            else if ( c == '}' && stack[pointer--] != '{' ) return false ;
        }
        return pointer == -1 ;
    }
}