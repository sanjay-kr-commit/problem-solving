// time taken 2 ms
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder st = new StringBuilder() ;
        for ( int i = 0 ; i < strs[0].length() ; i++ ) {
            boolean didMatched = true ;
            for ( String s : strs ) {
                if ( s.length() <= i || s.charAt(i) != strs[0].charAt(i) ) {
                    didMatched = false ;
                    break ;
                }
            }
            if ( !didMatched ) break ;
            st.append( strs[0].charAt(i) ) ;
        }
        return st.toString() ;
    }
}

// time taken 3 ms
class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        int end = -1 ;
        boolean loop = true ;
        while ( loop ) {
            end++;
            for ( int i = 0 ; i < strs.length-1 ; i++ ) {
                if ( strs[i].length() <= end || strs[i+1].length() <= end || strs[i].charAt(end) != strs[i+1].charAt(end) ) {
                    loop = false ;
                    break ;
                } 
            }
        }
        return ( end == 0 ) ? "" : strs[0].substring( 0 , end ) ;
    }
}

// time taken 1 ms
class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if ( strs == null || strs.length == 0 ) return "" ;
        else if ( strs.length == 1 ) return strs[0] ;
        String pre = strs[0] ;
        for ( int i = 0 ; i < strs.length ; i++ ) {
            while ( strs[i].indexOf(pre) != 0 ) pre = pre.substring( 0 , pre.length()-1 ) ;
        }
        return pre ;
    }
}