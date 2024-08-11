class Solution {

    int index;

    public int calculate(String s) {
        index = 0 ;
        return evaluate(s);
    }

    int evaluate(String s) {
        int num = 0, ans = 0;
        int sign = 1;
        while ( index < s.length() ) {
            char ch = s.charAt(index++);
            if ( ch >='0' && ch <= '9' ) num = num * 10 + ch - '0' ;
            else if ( ch == '(' ) num = evaluate(s);
            else if ( ch == ')' ) return ans+num*sign;
            else if ( ch == '+' || ch == '-' ) {
                ans += num * sign ;
                num = 0 ;
                // ascii value '+' = 43, '-'  = 45
                sign = (ch-44)*-1;
            }
        }
        return ans + num * sign ;
    }
}