class Solution {
    public int calculate(String s) {
        StringBuilder st = new StringBuilder( s );
        outer:
        while ( true ) {
            int[] stack = new int[ st.length() ] ;
            int l = 0 , r = st.length() - 1 ;
            for ( int i = 0 ; i < st.length() ; i++ ) {
                if ( st.charAt(i) == '(' ) stack[l++] = i ;
                else if ( st.charAt(i) == ')' ) {
                    l-- ;
                    if ( l == 0 ) {
                        st.replace(
                                stack[l] , i+1 , calculate(
                                        st.substring( stack[l]+1 , i )
                                ) + ""
                        ) ;
                        continue outer;
                    }
                }
            }
            break ;
        }
        char [] opStack = new char[st.length()] ;
        int [] intStack = new int[st.length()] ;
        int opIdx = 0 , intIdx = 0 , buff = 0 , neg = 1 , c = 0 ;
        for ( int i = 0 ; i < st.length() ; i++ ) {
            char ch = st.charAt( i ) ;
            switch ( ch ) {
                case ' ' : break;
                case '+' : case '-' : {
                    if ( ch == '-' && intIdx == 0 && c == 0 ) {
                        neg *= -1 ;
                        continue;
                    }
                    if ( c > 0 ) {
                        intStack[intIdx++] = buff * neg;
                        neg = 1;
                        buff = 0;
                        c = 0;
                    }
                    opStack[opIdx++] = ch ;
                    if ( opIdx > intIdx ) {
                        if ( opIdx < 2 ) continue;
                        opIdx-- ;
                        if ( opStack[opIdx-1] == '+' && ( opStack[opIdx] == '-' || opStack[opIdx] == '+' ) ) opStack[opIdx-1] = opStack[opIdx] ;
                        else if ( opStack[opIdx-1] == '-' && opStack[opIdx] == '-' ) opStack[opIdx-1] = '+' ;
                    }
                } break;
                default:{
                    buff *= 10 ;
                    buff += ch - '0' ;
                    c++ ;
                }
            }
        }
        if ( c > 0 ) intStack[intIdx++] = buff * neg ;
        int opStartIdx = 0 , intStartIdx = 0 ;
        while ( opStartIdx < opIdx ) {
            intStack[intStartIdx+1] = operate(
               opStack[opStartIdx++],
               intStack[intStartIdx] ,
               intStack[++intStartIdx]
            ) ;
        }
        return ( intStartIdx < intIdx ) ? intStack[intStartIdx] : 0 ;
    }

    int operate( char op , int a , int b ) {
        if ( op == '+' ) return a+b ;
        else if ( op == '*' ) return a*b ;
        else return a-b ;
    }

}