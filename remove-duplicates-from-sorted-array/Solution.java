/*
 * took 881 ms on leet code
 * bad code :(
*/
class Solution1 {

    public void shiftFrom( int index , int[] nums ) {
        for ( int i = index ; i < nums.length-1 ; i++ ) {
            nums[i] = nums[i+1] ;
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0 , k = nums.length-1;
        while ( i < k ) {
            if ( nums[i] == nums[i+1] ) {
                shiftFrom(i, nums);
                k-- ;
            } else i++ ;
        }
        return k+1 ;
    }
}

/*
 * took 8 ms on leet code
 * still bad code :(
*/
class Solution2 {
    public int removeDuplicates(int[] nums) {
        int i = 0 , k = nums.length-1 ;
        while ( i < k ) {
            if ( nums[i] == nums[i+1] ) {
                int j = i+1 ;
                while ( j < k && nums[j] == nums[j+1] ) j++;
                j -= i ;
                k -= j;
                for ( int l = i+1 ; l <= k ; l++ ){
                    nums[l] = nums[l+j] ;
                }
            }
            i++;
        }
        return k+1 ;
    }
}

/*
 * took 2 ms on leet code
 * decent code :(
*/
class Solution3 {
    public int removeDuplicates(int[] nums) {
        int pointer = 1 , previous = nums[0] ;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if ( previous != nums[i] ) {
                nums[pointer++] = nums[i] ;
                previous = nums[i];
            }
        } 
        return pointer;
    }
}