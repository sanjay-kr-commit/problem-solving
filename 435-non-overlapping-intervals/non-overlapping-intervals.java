class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int maxEnd = intervals[0][1];
        int minStart = maxEnd;

        for (int i = 1; i < intervals.length; i++) {
            minStart = Math.min(intervals[i][1], minStart);
            maxEnd = Math.max(intervals[i][1], maxEnd);
        }

        int maxRange = 2 + maxEnd - minStart;
        int[] rightEnds = new int[maxRange];

        int shift = 1 - minStart;
        for (int[] interval : intervals) {
            int right = interval[1] + shift;
            int left = interval[0] + shift;
            if (left > rightEnds[right]) {
                rightEnds[right] = left;
            }
        }

        int start = 1;
        int count = 1;
        for (int i = 2; i < maxRange; i++) {
            if (start <= rightEnds[i]) {
                start = i;
                count++;
            }
        }

        return intervals.length - count;
        
    }
}