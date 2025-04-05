class Solution {
    public int findDuplicate(int[] nums) {
        int [] dp = new int[nums.length+1];
        for ( int num : nums ) dp[num]++;
        for ( int num : nums ) if ( dp[num] > 1 ) return num;
        return -1; 
    }
}
