import java.util.*;

// 20 ms
class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( int i : nums ) {
            if ( map.containsKey(i) ) map.put(i, map.get(i)+1) ;
            else map.put(i, 1) ;
        }
        int j = 0 ;
        int n = 0 ;
        Iterator hm = map.entrySet().iterator();
        while ( hm.hasNext() ) {
            Map.Entry mapElement = (Map.Entry) hm.next() ;
            if ( (int)mapElement.getValue() > j ) {
                n = (int)mapElement.getKey() ;
                j = (int)mapElement.getValue() ;
            }
        }
        return n ;
    }
}

//Boyer's Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 , max = 0 ;
        for ( int i : nums ) {
            if ( count == 0 ) max = i ;
            if ( i == max ) count++ ;
            else count-- ;
        }
        return max ;
    }
}