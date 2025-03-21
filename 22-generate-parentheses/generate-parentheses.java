import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>( (int)Math.pow( 2 , n ) );
        fill( list , "" , n*2 , 0 , new char[2 * n] );
        return new ArrayList<>(list);
    }
    void fill(ArrayList<String> result , String parenthesis , int maxLen , int stackPointer , char [] stack ) {
        if ( parenthesis.length()  == maxLen ) {
            if ( stackPointer == 0 ) result.add( parenthesis );
            return;
        }
        stack[stackPointer++] = '(' ;
        fill( result , parenthesis+"(" , maxLen , stackPointer , stack  );
        stackPointer-- ;
        if ( stackPointer > 0 && stack[stackPointer-1] == '(' ) {
            stackPointer--;
            fill( result , parenthesis+")" , maxLen , stackPointer , stack  );
        }
    }
}