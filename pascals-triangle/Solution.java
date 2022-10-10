import java.util.List ;
import java.util.ArrayList ;
// took 1 ms
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        for ( int i = 0 ; i < numRows ; i++ ) {
            List<Integer> row = new ArrayList<>(i+1) ;
            row.add( 1 );
            for ( int j = 1 ; j < i ; j++ ) {
                row.add( 
                    pascal.get( i - 1 ).get( j -1 ) + pascal.get( i -1 ).get( j ) 
                ) ;
            }
            if ( i != 0 ) row.add( 1 ) ;
            pascal.add( row ) ;
        }
        return pascal ;
    }
}

// 1ms
class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        pascal.add( new ArrayList<>(1) ) ;
        pascal.get(0).add(1) ;
        for ( int i = 1 ; i < numRows ; i++ ) {
            pascal.add( new ArrayList<>(i+1) ) ;
            pascal.get(i).add( 1 );
            for ( int j = 1 ; j < i ; j++ ) {
                pascal.get(i).add( 
                    pascal.get( i - 1 ).get( j -1 ) + pascal.get( i -1 ).get( j ) 
                ) ;
            }
            pascal.get(i).add( 1 ) ;
        }
        return pascal ;
    }
}

// 0ms
class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for(int i=1;i<numRows;i++) {
            list.add(new ArrayList<>());
            list.get(i).add(1);
            for(int j=1;j<i;j++) {
                list.get(i).add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            list.get(i).add(1);
        }
        return list;
    }
}