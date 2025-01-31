import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> combinations = new ArrayList<>();
        calculatePermutation(
                k , n , combinations
                , 0L , new HashSet<>() ,
                0 , 0
        );
        return combinations ;
    }

    void calculatePermutation(
            int places , int target , ArrayList<List<Integer>> combinations ,
            long occupiedNumber , HashSet<Long> occupiedSet , int sum , int placesOccupied
    ) {
        if ( placesOccupied == places ) {
            if ( sum != target || occupiedSet.contains( occupiedNumber ) ) return;
            occupiedSet.add( occupiedNumber );
            ArrayList<Integer> combination = new ArrayList<>();
            for ( int i = 0 ; i < 60 ; i++ ) {
                if ( ((occupiedNumber>>i)&1L) != 1L ) continue;
                combination.add(i+1);
            }
            combinations.add(combination);
        }
        if ( occupiedSet.contains( occupiedNumber) || sum >= target ) return;
        occupiedSet.add( occupiedNumber );
        for ( int i = 0 ; i < 9 ; i++ ) {
            if ( ((occupiedNumber>>i)&1L) == 1L ) continue;
            occupiedSet.add( occupiedNumber );
            calculatePermutation( places , target , combinations , (occupiedNumber | ( 1L << i )) , occupiedSet , sum+i+1 , placesOccupied+1 ) ;
        }
    }
}