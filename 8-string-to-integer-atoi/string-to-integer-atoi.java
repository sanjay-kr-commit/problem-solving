//class Solution {
//    public String minimumString(String a, String b, String c) {
//        StringBuilder st = new StringBuilder(a.length() + b.length() + c.length() );
//
//        return st.toString() ;
//    }
//}

class Solution {

    public int myAtoi(String s) {
        int result = 0;
        boolean negative = false;
        int maxValue = Integer.MAX_VALUE / 10 ;
        int i = 0 ;
        while ( i < s.length() && s.charAt( i ) == ' ' ) i++ ;
        if ( i < s.length() && (s.charAt( i ) == '-' || s.charAt( i ) == '+') ) {
            negative = s.charAt( i ) == '-';
            i++ ;
        }
        while ( i < s.length() && s.charAt( i ) == '0' ) i++ ;
        if ( i < s.length() && !isDigit(s.charAt(i)) ) return result ;
        while ( i < s.length() && isDigit(s.charAt( i )) ) {
            if ( result > maxValue ) return (!negative) ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            if ( result == maxValue && ( (negative && s.charAt(i)>'8') || (!negative&&s.charAt(i)>'7') ) ) return (!negative) ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            if ( result == Integer.MIN_VALUE || result == Integer.MAX_VALUE ) return (!negative) ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            result *= 10 ;
            result += s.charAt( i ) - '0' ;
            i++ ;
        }
        return (negative) ? -1*result : result ;
    }

    boolean isDigit(char c) {
        return c >= '0' && c <= '9' ;
    }

}