import java.util.ArrayList;
import java.util.List;

// 0ms
class Solution2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>() ;
        if ( nums.length == 0 ) return list ;
        StringBuilder range = new StringBuilder() ;
        for ( int i= 0 ; i < nums.length-1 ; i++ ) {
            if ( range.isEmpty() ) range.append( nums[i] ) ;
            if ( nums[i]+1 != nums[i+1] ) {
                if ( i != 0 && nums[i-1]+1 == nums[i] ) {
                    range.append( "->" ) ;
                    range.append( nums[i] ) ;
                }
                list.add( range.toString() ) ;
                range = new StringBuilder() ;
            }
        }
        if ( ! range.isEmpty() ) range.append( "->" ) ;
        range.append( nums[nums.length-1] ) ;
        list.add( range.toString() ) ; 
        return list;
    }
}

// 1ms
class Solution1 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>() ;
        if ( nums.length == 0 ) return list ;
        StringBuilder st = new StringBuilder() ;
        for ( int i = 0 ; i < nums.length-1 ; i++ ) {
            if ( st.isEmpty() ) st.append( nums[i] ) ;
            if ( nums[i]+1 != nums[i+1] ) {
                int pre = 0 ;
                for ( int j = 0 ; j < st.length() ; j++ ) {
                    if ( st.charAt(j) == '-' ) continue ;
                    pre *= 10 ;
                    pre += st.charAt(j)-'0' ;
                } 
                if ( st.charAt(0) == '-' ) pre *= -1 ;
                if ( pre != nums[i] ) {
                    st.append( "->" ) ;
                    st.append( nums[i] ) ;
                }
                list.add( st.toString() ) ;
                st = new StringBuilder() ;
            }
        }
        if ( ! st.isEmpty() ) st.append( "->" ) ;
        st.append( nums[nums.length-1] ) ;
        list.add( st.toString() ) ; 
        return list ;
    }
}