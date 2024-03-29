mport java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        ArrayList<List<Integer>> list = new ArrayList<>(s.length()) ;
        int j = 0 ;
        for ( int i = 1 ; i < s.length() ; i++ ) {
            if ( s.charAt( i ) != s.charAt( j ) ) {
                if ( i-j > 2 ) {
                    ArrayList<Integer> largeGroup = new ArrayList<>(2) ;
                    largeGroup.add( j ) ;
                    largeGroup.add( i-1 ) ;
                    list.add( largeGroup ) ;
                }
                j = i ;
            }
        }
        if ( s.length()-j > 2 ) {
            ArrayList<Integer> largeGroup = new ArrayList<>(2) ;
            largeGroup.add( j ) ;
            largeGroup.add( s.length()-1 ) ;
            list.add( largeGroup ) ;
        }
        return list ;
    }
}
