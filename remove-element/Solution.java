/*
 * took 0 ms
*/
class Solution {
    public int removeElement( int[]nums , int val ) {
        int k = nums.length ;
        for ( int i = 0 ; i < k ; i++ ) {
            if ( nums[i] == val ) {
                int j = i ;
                while ( j < k-1 && nums[j+1] == val ) j++ ;
                j -= i-1 ;
                k -= j ;
                for ( int l = i ; l < k ; l++ ) nums[l] = nums[l+j] ;
                i--;
            }
        }
        return k ;
    }
}