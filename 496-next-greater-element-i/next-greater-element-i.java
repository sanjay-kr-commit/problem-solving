import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length] ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for ( int i = 0 ; i < nums2.length ; i++ ) map.put( nums2[i] , i ) ;
        for ( int i = 0 ; i < nums1.length ; i++ ) {
            ans[i] = -1 ;
            int index = ( map.get( nums1[i] ) != null ) ? map.get( nums1[i] ) + 1 : -1 ;
            if ( index == -1 || index >= nums2.length ) continue ;
            while ( index < nums2.length && nums2[index] <= nums1[i] ) index++ ;
            if ( index < nums2.length ) ans[i] = nums2[index] ;
        }
        return ans ;
    }
}