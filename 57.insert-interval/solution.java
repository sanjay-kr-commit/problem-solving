import java.util.ArrayList;

// @leet start
class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    ArrayList<int[]> list = new ArrayList<>(intervals.length + 1);
    boolean isUsed = intervals.length == 0 || intervals[0][0] > newInterval[0];
    int i = 0;
    list.add((isUsed) ? newInterval : intervals[i++]);
    int ls = 0, prevEnd = list.get(ls)[1];

    for (; !isUsed && i < intervals.length;) {
      isUsed = intervals[i][0] > newInterval[0];
      int[] temp = (isUsed) ? newInterval : intervals[i];
      if (!isUsed)
        i++;
      if (prevEnd >= temp[0]) {
        prevEnd = Math.max(prevEnd, temp[1]);
        list.get(ls)[1] = prevEnd;
      } else {
        list.add(temp);
        ls++;
        prevEnd = Math.max(prevEnd, temp[1]);
      }
    }
    for (; i < intervals.length; i++) {
      if (prevEnd >= intervals[i][0]) {
        prevEnd = Math.max(prevEnd, intervals[i][1]);
        list.get(ls)[1] = prevEnd;
      } else {
        list.add(intervals[i]);
        ls++;
        prevEnd = Math.max(prevEnd, intervals[i][1]);
      }
    }

    if (!isUsed) {
      if (list.get(ls)[1] >= newInterval[0])
        list.get(ls)[1] = Math.max(prevEnd, newInterval[1]);
      else
        list.add(newInterval);
    }

    int[][] res = new int[list.size()][];
    i = 0;
    for (int[] interval : list)
      res[i++] = interval;
    return res;

  }
}
// @leet end
