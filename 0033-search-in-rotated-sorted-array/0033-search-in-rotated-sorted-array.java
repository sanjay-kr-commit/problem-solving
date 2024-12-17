public class Solution {
    public int search(int[] nums, int target) {
        int rotation = 0 ,
            len = nums.length ,
            l = 0 , r = len - 1 , mid , lui ;
        if ( len > 1 && nums[0] >= nums[len-1] ) {
            do rotation++;
            while (rotation < len && nums[rotation - 1] < nums[rotation]);
        }
        while ( l < r  ) {
            mid = (l+r)/2;
            lui = (mid + rotation)%len ;
            if ( nums[lui] == target ) return lui ;
            else if ( nums[lui] > target ) r = mid ;
            else l = mid+1 ;
        }
        lui = (((l + r) / 2) + rotation) % len;
        return ( r == l && nums[lui] == target ) ? lui : -1 ;
    }
}