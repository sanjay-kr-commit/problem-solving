import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int countPairs(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>() ;
        int count = 0 ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( !map.containsKey( nums[i] ) ) map.put( nums[i] , new ArrayList<>() ) ;
            map.get(nums[i]).add(i) ;
        }
        for ( int i : map.keySet() ) {
            ArrayList<Integer> list = map.get( i ) ;
            for ( int j = 0 ; j < list.size()-1 ; j++ ) {
                for ( int l = j+1 ; l < list.size() ; l++ ) {
                    if ( (list.get(j)*list.get(l))%k == 0 ) count++ ;
                }
            }
        }
        return count ;
    }
}
