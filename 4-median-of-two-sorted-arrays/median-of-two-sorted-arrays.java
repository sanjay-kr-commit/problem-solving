class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0 , b = 0 ;
        int i = 0 , j = 0 , k = 0 ,
            l = nums1.length + nums2.length , h = (l/2)+1 ;
        while ( k < h && i < nums1.length && j < nums2.length ) {
            a = b ;
            b = ( nums1[i] < nums2[j] ) ? nums1[i++] : nums2[j++];
            k++ ;
        }
        while ( k < h && i < nums1.length ) {
            a = b ;
            b = nums1[i++] ;
            k++ ;
        }
        while ( k < h && j < nums2.length ) {
            a = b ;
            b = nums2[j++] ;
            k++ ;
        }
        if ( l % 2 == 1 ) return b ;
        else return (a+b)/2.0 ;
    }
}