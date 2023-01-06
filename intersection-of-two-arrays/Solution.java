import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer> set = new HashSet<>() ;
      for ( int i = 0 ; i < nums1.length ; i++ ) set.add( nums1[i] ) ;
      ArrayList<Integer> unique = new ArrayList<>() ;
      for ( int i = 0 ; i < nums2.length ; i++ ) {
        if ( set.contains( nums2[i] ) && !unique.contains( nums2[i] ) ) unique.add( nums2[i] ) ;
      }
      return unique.stream().mapToInt(i -> i).toArray() ;
    }
}
