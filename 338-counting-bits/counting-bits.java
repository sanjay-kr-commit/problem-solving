class Solution {
    public int[] countBits(int n) {
        int [] dp = new int[n+1];
        rcdp(dp, 1, 1);
        return dp;
    }

    public void rcdp( int [] dp, int index, int numsOnes ) {
        if( index >= dp.length ) return;
        dp[index] = numsOnes;
        rcdp(dp, index*2, numsOnes);
        rcdp(dp, index*2+1, numsOnes+1);
    }
}