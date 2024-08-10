class Solution {
    public int calculate(String s) {
        int result = 0 ;
        char [] opStack = new char[ s.length() ] ;
        int [] intStack = new int[ s.length() ] ;
        int[] op = new int[ 128 ] ;
        op['*'] = 1 ;op['+'] = 1 ;op['-'] = 1 ;op['/'] = 1 ;
        int opIdx = 0 , intIdx = 0 ;
        int buff = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char ch = s.charAt(i) ;
            if (op[ch]==1) {
                intStack[intIdx++] = buff ;
                buff = 0 ;
                if ( opIdx > 0 && ( opStack[opIdx-1] == '/' || opStack[opIdx-1] == '*') ) {
                    intStack[intIdx - 2] = operate(opStack[--opIdx], intStack[intIdx-2], intStack[intIdx-1]);
                    intIdx-- ;
                }
                opStack[ opIdx++ ] = ch ;
            } else if ( ch != ' ' ) {
                buff *= 10 ;
                buff += ch - '0' ;
            }
        }
        if ( buff > 0 ) {
            intStack[intIdx++] = buff ;
            if ( opIdx > 0 && ( opStack[opIdx-1] == '/' || opStack[opIdx-1] == '*') ) {
                intStack[intIdx - 2] = operate(opStack[--opIdx], intStack[intIdx-2], intStack[intIdx-1]);
                intIdx-- ;
            }
        }
        int opStartIdx = 0 , intStartIdx = 0 ;
        while ( opStartIdx < opIdx ) {
            intStack[++intStartIdx] = operate( opStack[opStartIdx++] , intStack[intStartIdx-1] , intStack[intStartIdx] ) ;
        }
        return ( intStartIdx < intIdx) ? intStack[intStartIdx] : 0 ;
    }

    int operate( char op , int a , int b ) {
        if ( op == '/' ) return a/b ;
        else if ( op == '*' ) return a*b ;
        else if ( op == '+' ) return a+b ;
        else return a-b ;
    }
}