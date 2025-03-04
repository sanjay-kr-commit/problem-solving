import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        long goodPairs = 0 , totalPairs = 0 ;
        for ( int i = 0 , len = nums.length ,
              len1 = len-1
              ; i < len ; i++
        ) {
            totalPairs += len1-i ;
        }
        HashMap<Integer,Long> cache = new HashMap<>();
        for ( int i = nums.length-1 ; i > -1 ; i-- ) {
            int index = nums[i] - i ;
            goodPairs += cache.getOrDefault(index,0L) ;
            cache.put(
                    index ,
                    cache.getOrDefault(index,0L) + 1
            ) ;
        }
        return totalPairs - goodPairs ;
    }
}