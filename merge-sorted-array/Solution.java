class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copiedArray = new int[ m ] ;
            for ( int i = 0 ; i < m ; i ++ ) copiedArray[i] = nums1[i] ;
            int i = 0 , j = 0 , k = 0 ;
            while ( i < m && j < n ) {
                nums1[k++] = ( copiedArray[i] < nums2[j] ) ? copiedArray[i++] : nums2[j++] ;
            }
            while ( i < m ) nums1[k++] = copiedArray[i++] ;
            while ( j < n ) nums1[k++] = nums2[j++] ;
    }
}