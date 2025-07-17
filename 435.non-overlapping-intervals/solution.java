import java.util.Arrays;

// @leet start

class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      int comparison = Integer.compare(a[0], b[0]);
      return comparison;
    });

    int removed = 0;

    for (int i = 1, prevEnd = intervals[0][1]; i < intervals.length; i++) {
      if (intervals[i][0] < prevEnd) {
        removed++;
        prevEnd = Math.min(prevEnd, intervals[i][1]);
      } else
        prevEnd = intervals[i][1];
    }

    return removed;
  }
}
// @leet end
