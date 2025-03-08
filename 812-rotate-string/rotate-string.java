class Solution {
    public boolean rotateString(String s, String goal) {
        if ( s.length() != goal.length() ) return false;
        if ( s.isEmpty() ) return true ;
        outer:
        for ( int i = 0 ; i < s.length() ; i++ ) {
            for ( int j = 0 ; j < goal.length() ; j++ ) {
                if ( goal.charAt( (i+j)%s.length() ) != s.charAt( j ) ) continue outer;
            }
            return true ;
        }
        return false ;
    }
}