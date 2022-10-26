import java.util.HashMap;

// 1580 ms
class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if ( k == 0 ) return false ;
        int i = 0 ;
        while ( i < nums.length ) {
            for ( int j = ( (i+k >= nums.length)?nums.length-1 : i+k ) ; j > i ; j-- ) {
                if ( nums[j] == nums[i] ) return true ;
            }
            i++ ;
        } 
        return false ;       
    }
}

// 48 ms
class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if ( k == 0 ) return false ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int num = nums[i] ;
            if ( map.containsKey(num) && i - map.get(num) <= k ) return true ;
            map.put( num, i) ;
        }    
        return false ; 
    }
}