class Solution {
  public int[] countBits(int n) {
    int [] dp = new int[n+1];
    recursiveCount(dp, 1, 1);
    return dp;
  }

  public void recursiveCount(int [] dp, int index, int numsOnes ) {
    if( index >= dp.length ) return;
    dp[index] = numsOnes;
    recursiveCount(dp, index*2, numsOnes);
    recursiveCount(dp, index*2+1, numsOnes+1);
  }
}