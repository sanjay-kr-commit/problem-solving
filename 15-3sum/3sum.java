import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>( nums.length );
        for ( int i = 0 , len = nums.length ; i < len ; i++ ) {
            int left = i + 1 , right = len - 1;
            int x = -nums[i] ;
            while ( left < right ) {
                int sum = nums[left] + nums[right];
                if ( sum > x ) right-- ;
                else if ( sum < x ) left++ ;
                else {
                    ArrayList<Integer> toAdd = new ArrayList<>( 3 );
                    toAdd.add( nums[i] );
                    toAdd.add( nums[left] );
                    toAdd.add( nums[right] );
                    result.add(toAdd);
                    len-- ;
                    while ( left < len && nums[left] == nums[left + 1] ) left++ ;
                    len++ ;
                    while ( right > left && nums[right] == nums[right-1] ) right-- ;
                    left++ ;
                    right-- ;
                }
            }
            len-- ;
            while ( i < len && nums[i] == nums[i+1] ) i++ ;
            len++ ;
        }
        return result ;
    }
}