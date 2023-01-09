import java.util.ArrayList;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     ArrayList<Integer> list = new ArrayList<>();
     boolean map[] = new boolean[nums.length] ;
     for ( int i : nums ) map[i-1] = true ;
     for ( int i = 0 ; i < nums.length ; i++ ) if ( !map[i] ) list.add( i+1 ) ;
     return list ;
    }
}
