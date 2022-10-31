// 150 ms
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0 , len = nums.length ;
        while ( i < len ) {
            if ( nums[i] == 0 ) {
                int j = i ;
                while ( j < nums.length && nums[j] == 0 ) j++ ; 
                int l = j ;
                while ( l < nums.length && nums[l] != 0 ) l++ ;
                int gap = j - i ;
                for ( int k = i ; k < len - gap ; k++ ) {
                    nums[k] = nums[k+gap] ;
                    nums[k+gap] = 0 ;
                }
            }
            i++ ;
        }       
    }
}

// 49 ms
class Solution1 {
    public void moveZeroes(int[] nums) {
        int i = 0 , len = nums.length ;
        while ( i < len ) {
            if ( nums[i] == 0 ) {
                int j = i ;
                while ( j < nums.length && nums[j] == 0 ) j++ ; 
                int l = j ;
                while ( l < nums.length && nums[l] != 0 ) l++ ;
                int gap = j - i ;
                for ( int k = i ; k < l - gap ; k++ ) {
                    nums[k] = nums[k+gap] ;
                    nums[k+gap] = 0 ;
                }
            }
            i++ ;
        }       
    }
}

// 3 ms
class Solution2 {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while( i < nums.length ){
            if(nums[i]!=0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
            }
            i++;
        }
    }
}