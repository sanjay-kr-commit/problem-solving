import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> subsets = new ArrayList<>();
        subsets(subsets,new ArrayList<>() , 0 , nums, new HashSet<>(), new boolean[nums.length] ) ;
        return subsets ;
    }

    void subsets(ArrayList<List<Integer>> subsets , ArrayList<Integer> subset , int index , int [] nums , HashSet<String> used , boolean [] temp ) {
        Arrays.fill( temp , false ) ;
        for ( int i : subset ) temp[i] = true ;
        StringBuilder st = new StringBuilder() ;
        for ( int i = 0 ; i < temp.length ; i++ ) {
            if ( temp[i] ) st.append( i ).append(",") ;
        }
        if (! used.contains( st.toString() ) ) {
            used.add( st.toString() ) ;
            ArrayList<Integer> tempSubset = new ArrayList<>() ;
            for ( int i : subset ) {
                tempSubset.add( nums[i] ) ;
            }
            subsets.add( tempSubset ) ;
        }
        if ( index == nums.length ) return;
        ArrayList<Integer> path1 = new ArrayList<>(subset),
                path2 = new ArrayList<>(subset);
        path1.add(index++);
        subsets(subsets , path1 , index , nums, used , temp) ;
        subsets(subsets , path2 , index , nums, used, temp) ;
    }

}
