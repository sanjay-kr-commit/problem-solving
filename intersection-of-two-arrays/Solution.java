class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean [] map = new boolean[1001] ;
        for ( int i = 0 ; i < nums1.length ; i++ ) map[nums1[i]] = true ;
        ArrayList<Integer> unique = new ArrayList<>() ;
        for ( int i = 0 ; i < nums2.length ; i++ ){
            if ( map[nums2[i]] ) {
                unique.add( nums2[i] ) ;
                map[nums2[i]] = false ;
            }
        }
        return unique.stream().mapToInt(i -> i).toArray();
    }
}
