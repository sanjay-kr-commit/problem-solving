class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0 ,
            max = Integer.MIN_VALUE ;
        for ( int i : nums ) {
            sum += i ;
            max = max < sum ? sum : max ;
            sum = sum < 0 ? 0 : sum ;
        }
        return max ;
    }
}