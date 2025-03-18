import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        outer:
        for ( int i = 0 ; i < nums.length-2; i++ ) {
            int x = -nums[i] ;
            int left = i+1 , right = nums.length - 1 ;
            while ( left < right ) {
                int y = x-nums[left] ;
                if ( y < nums[left]) continue outer;
                while ( right > left && nums[right] > y ) right-- ;
                if ( left != right && nums[right] == y ) {
                    String s = nums[i] + "," + nums[left] + "," + nums[right];
                    if ( !set.contains(s) ) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add( list ) ;
                        set.add(s);
                    }
                }
                left++ ;
            }
        }
        return res ;
    }
}
