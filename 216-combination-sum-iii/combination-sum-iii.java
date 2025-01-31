import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> combinations = new ArrayList<>();
        calculatePermutations(
                k , n , 0 , 0 , 0 , combinations , new HashSet<>()
        );
        return combinations ;
    }

    void calculatePermutations(
            int places , int target , int sum , int placesOccupied , int numOccupied ,
            ArrayList<List<Integer>> combinations , HashSet<Integer> occupiedSet
    ) {
        if ( occupiedSet.contains( numOccupied ) ) return;
        occupiedSet.add( numOccupied );
        if ( places == placesOccupied ) {
            if ( sum != target ) return;
            ArrayList<Integer> combination = new ArrayList<>( places );
            for ( int i = 0 ; i < 9 ; i++ ) {
                if ( (numOccupied&1) == 1 ) combination.add( i + 1 ) ;
                numOccupied >>= 1 ;
            }
            combinations.add( combination );
            return;
        }
        if ( sum >= target ) return;
        long localNumOccupied = numOccupied ;
        for ( int i = 0 ; i < 9 ; i++ ) {
            if ( (localNumOccupied & 1) == 1 ) continue;
            calculatePermutations(
                    places , target , sum + i + 1 , placesOccupied+1 , ( numOccupied | ( 1 << i ) ) ,
                    combinations , occupiedSet
            );
            localNumOccupied >>= 1 ;
        }
    }

}