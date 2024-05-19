import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> scopeStack = new Stack<>() ;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c == '(' || c == '{' || c == '[' ) scopeStack.push( c ) ;
            else if ( c == ')' || c == '}' || c == ']' ) {
                // no opening pair found
                if ( scopeStack.isEmpty() ) return false ;
                char openPair = scopeStack.pop();
                // pair mismatch
                if ( c == ')' && openPair != '(') return false;
                if ( c == '}' && openPair != '{' ) return false;
                if ( c == ']' && openPair != '[' ) return false;
            }
        }
        return scopeStack.empty() ;
    }
}