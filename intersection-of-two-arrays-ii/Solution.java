class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] map = new int[1001] ;
        for ( int i = 0 ; i < nums1.length ; i++ ) map[nums1[i]]++ ;
        ArrayList<Integer> unique = new ArrayList<>() ;
        for ( int i = 0 ; i < nums2.length ; i++ ){
            if ( map[nums2[i]] != 0 ) {
                unique.add( nums2[i] ) ;
                map[nums2[i]]-- ;
            }
        }
        return unique.stream().mapToInt(i -> i).toArray();       
    }
}
