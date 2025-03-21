import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>( (int)Math.pow( 2 , n ) );
        int maxLen = n * 2 ;
        fill( list , new StringBuilder(maxLen) , maxLen , 0 , new char[maxLen] );
        return new ArrayList<>(list);
    }
    void fill(ArrayList<String> result , StringBuilder parenthesis , int maxLen , int stackPointer , char [] stack ) {
        if ( parenthesis.length()  == maxLen ) {
            if ( stackPointer == 0 ) result.add( parenthesis.toString() );
            return;
        }
        stack[stackPointer++] = '(' ;
        parenthesis.append('(') ;
        fill( result , parenthesis , maxLen , stackPointer , stack  );
        parenthesis.deleteCharAt(parenthesis.length()-1);
        stackPointer-- ;
        if ( stackPointer > 0 && stack[stackPointer-1] == '(' ) {
            stackPointer--;
            parenthesis.append( ')' ) ;
            fill( result , parenthesis , maxLen , stackPointer , stack  );
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }
    }
}