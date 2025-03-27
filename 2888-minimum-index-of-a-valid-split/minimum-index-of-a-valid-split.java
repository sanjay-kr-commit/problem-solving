import java.util.HashMap;
import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for ( int i = 0 ; i < nums.size() ; i++ ) {
            map.put( nums.get(i), map.getOrDefault(nums.get(i), 0) + 1 );
        }
        for ( int i = 0 ; i < nums.size() ; i++ ) {
            map2.put( nums.get(i), map2.getOrDefault(nums.get(i), 0) + 1 );
            map.put( nums.get(i) , map.getOrDefault(nums.get(i), 0) - 1 );
            if (map2.get(nums.get(i))*2 > (i+1) && map.get(nums.get(i))*2 > (nums.size()-i-1)) return i;
        }
        return -1;
    }
}