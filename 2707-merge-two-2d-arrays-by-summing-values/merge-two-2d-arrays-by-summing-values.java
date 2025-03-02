class Solution {
  public int[][] mergeArrays(
    int[][] nums1, int[][] nums2
  ) {
    int count = 0 , i = 0 , j = 0 ;
    while ( i < nums1.length && j < nums2.length ) {
      if ( nums1[i][0] == nums2[j][0] ) {
        i++ ; j++ ;
      } else if ( nums1[i][0] < nums2[j][0] ) i++ ;
      else j++ ;
      count++ ;
    }
    count += (nums1.length-i) + ( nums2.length-j) ;
    int [][] merged = new int [count][2] ;
    i = 0 ; j = 0 ; int k = 0 ;
    while ( i < nums1.length && j < nums2.length ) {
      if ( nums1[i][0] == nums2[j][0] ) {
        merged[k++] = new int [] { 
          nums1[i][0] , nums1[i++][1] + nums2[j++][1] 
        } ;
      } else if ( nums1[i][0] < nums2[j][0] ) merged[k++] = nums1[i++] ;
      else merged[k++] = nums2[j++] ;
    }
    while ( i < nums1.length ) merged[k++] = nums1[i++] ;
    while ( j < nums2.length ) merged[k++] = nums2[j++] ;
    return merged ;
  }
}

