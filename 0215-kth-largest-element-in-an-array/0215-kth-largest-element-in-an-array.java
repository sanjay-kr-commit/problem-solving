class Solution {
    public int findKthLargest(int[] nums, int k) {
        if ( nums.length == 0 ) return -1;
        int min = nums[0] , max = nums[0];
        for ( int i : nums ) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int [] frequency = new int[max - min + 1];
        for ( int i : nums ) frequency[i-min]++ ;
        int index = frequency.length-1 ;
        while ( k > 1 ) {
            while ( index > -1 && frequency[index] == 0 ) index-- ;
            frequency[index]--;
            k-- ;
        }
        while ( index > -1 && frequency[index] == 0 ) index-- ;
        return index+min;
    }
}
