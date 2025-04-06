import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for ( int i : nums ) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int [] maxFlag = new int[max - min + 1];
        int [] result = new int[nums.length - k + 1];
        max = 0 ;
        int l = 0 , r = 0 , len = nums.length ;
        while ( r < k ) {
            max = Math.max(max, nums[r]);
            maxFlag[nums[r++]-min]++ ;
        }
        result[l] = max;
        while ( r < len ) {
            int index = nums[l++]-min ;
            maxFlag[index]-- ;
            if ( max == nums[l-1] ) {
                while ( index > -1 && maxFlag[index] == 0 ) index-- ;
                max = index+min ;
            }
            index = nums[r]-min ;
            maxFlag[index]++ ;
            if ( max < nums[r] ) max = nums[r] ;
            r++ ;
            result[l] = max;
        }
        return result ;
    }

}