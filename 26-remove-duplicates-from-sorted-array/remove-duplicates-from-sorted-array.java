class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length ;
        for ( int i = size-1 , j ; i > 0 ; i-- ) {
            if ( nums[i] != nums[i-1] ) continue;
            j = i-1 ;
            while ( j > -1 && nums[j] == nums[i] ) j-- ;
            j++ ;
            for ( int k = i ; k < size ; k++ ) {
                nums[j++] = nums[k] ;
            }
            size = j ;
            i = j-1 ;
        }
        return size;
    }
}