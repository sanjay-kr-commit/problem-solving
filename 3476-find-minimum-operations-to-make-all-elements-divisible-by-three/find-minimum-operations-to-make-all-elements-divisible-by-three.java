class Solution {
    public int minimumOperations(int[] nums) {
        int op = 0 ;
        for ( int num : nums ) op += Math.min( num % 3 , 3 - (num%3) ) ;
        return op ;
    }
}