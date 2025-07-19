import java.util.ArrayList;
import java.util.Arrays;

// @leet start
class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      return Integer.compare(a[0], b[0]);
    });
    ArrayList<int[]> list = new ArrayList<>(intervals.length);
    list.add(intervals[0]);
    for (int i = 1, ls = 0, prevEnd = intervals[0][1]; i < intervals.length; i++) {
      if (intervals[i][0] <= prevEnd) {
        prevEnd = Math.max(prevEnd, intervals[i][1]);
        list.get(ls)[1] = prevEnd;
      } else {
        list.add(intervals[i]);
        prevEnd = Math.max(prevEnd, intervals[i][1]);
        ls++;
      }
    }
    int[][] mergedInterval = new int[list.size()][];
    int i = 0;
    for (int[] interval : list)
      mergedInterval[i++] = interval;
    return mergedInterval;
  }
}
// @leet end
