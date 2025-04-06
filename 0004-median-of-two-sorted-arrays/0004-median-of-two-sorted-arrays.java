class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0 , b = 0,
                i = 0 , j = 0 , k = 0 ,
                mid = ( nums1.length + nums2.length ) / 2;
        mid++ ;
        while ( k < mid && i < nums1.length && j < nums2.length ) {
            a = b ;
            b = ( nums1[i] < nums2[j] ) ? nums1[i++] : nums2[j++];
            k++ ;
        }
        while ( k < mid && i < nums1.length ) {
            a = b ;
            b = nums1[i++];
            k++ ;
        }
        while ( k < mid && j < nums2.length ) {
            a = b ;
            b = nums2[j++];
            k++ ;
        }
        return ( (nums1.length+nums2.length)%2 == 1 ) ? b : (double) (a+b)/2 ;
    }
}