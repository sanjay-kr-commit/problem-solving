import java.util.Stack;

//with stack
// 3ms on leetcode
class Solution1 {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char bracket = s.charAt( i ) ;
            if (
                bracket == '(' || bracket == '[' || bracket == '{'
             ) brackets.push( bracket ) ;
             else if ( bracket == ')' || bracket == ']' || bracket == '}' ) {
                if ( brackets.isEmpty() ) return false ;
                switch ( brackets.peek() ) {
                    case '(' : if ( bracket != ')' ) return false ; break ;
                    case '[' : if ( bracket != ']' ) return false ; break ;
                    case '{' : if ( bracket != '}' ) return false ; break ;
                    default : continue ; 
                }
                brackets.pop();
             }
        }
        return brackets.isEmpty() ;      
    }
}

/*
* time taken 0 ms
* for any variable 'x' , x-- is not same as --x or x++ isn't same as ++x
* when ++ or -- operator after a variable the operation will be applied 
* after the current statement or operation is finished 
* while when applied before the operator operation will be applied
* first and the statement later*/
class Solution2 {
    public boolean isValid( String s ) {
        if ( s == null || s.length() == 1 ) return  false ;
        char[] stack = new char[s.length()];
        int pointer = 0 ;
        for ( char c : s.toCharArray() ) {
            switch ( c ) {
                case '(' : case '[' : case '{' : stack[pointer++] = c ;
                    break;
                case ')' :
                    if ( pointer == 0 || stack[--pointer] != '(' ) return false ;
                    break;
                case ']' :
                    if ( pointer == 0 || stack[--pointer] != '[' ) return false ;
                    break;
                case '}' :
                    if ( pointer == 0 || stack[--pointer] != '{' ) return false ;
                    break;
            }
        }
        return pointer == 0 ;
    }
}