import java.util.ArrayList;
import java.util.List;

// 4ms
class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascal = new ArrayList<>(1);
        pascal.add( 1 ) ;
        for ( int i = 1 ; i <= rowIndex ; i++ ) {
            List<Integer> temp = new ArrayList<>(i) ;
            temp.add(1) ;
            for ( int j = 1 ; j < i ; j++ ) {
                temp.add( 
                    pascal.get( j-1 ) + pascal.get( j )    
                );
            }
            temp.add(1 ) ;
            pascal = temp ; 
        }
        return pascal ;
    }
}

// 1ms
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascal = new ArrayList<>(rowIndex+1);
        pascal.add( 1 ) ;
        for ( int i = 1 ; i <= rowIndex ; i++ ) {
            for ( int j = i-1 ; j >= 1 ; j-- ) {
                pascal.set( j, pascal.get(j-1) + pascal.get(j)) ;
            } 
            pascal.add( 1 ) ;
        }
        return pascal ;
    }
}