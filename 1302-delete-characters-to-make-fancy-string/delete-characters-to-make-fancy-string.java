class Solution {
    public String makeFancyString(String s) {
        if ( s.length() < 3 ) return s;
        StringBuilder sb = new StringBuilder();
        char a = s.charAt(0) , b = s.charAt(1);
        sb.append(a);
        sb.append(b);
        for ( int i = 2; i < s.length(); i++ ) {
            if ( a == b && s.charAt(i) == b ) continue;
            else sb.append(s.charAt(i));
            a = b ;
            b = s.charAt(i) ;
        }
        return sb.toString(); 
    }
}