import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0 ; int value = 0 ;
        for ( int num : nums ) {
            if ( map.containsKey(num) ) {
                int lsum = map.get(num) + 1 ;
                if ( lsum > max ) {
                    max = lsum ;
                    value = num ;
                }
                map.put( num , lsum ) ;
            } else {
                map.put( num , 1 ) ;
                if ( max == 0 ) {
                    max = 1 ;
                    value = num ;
                }
            }
        }
        return value ;
    }
}