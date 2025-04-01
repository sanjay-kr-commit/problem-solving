class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2 ; i >= 0 ; i--) {
            long take = questions[i][0];
            int newIndex = i + questions[i][1] + 1;
            take += (newIndex < n) ? dp[newIndex] : 0;
            long notTake = dp[i + 1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }
}