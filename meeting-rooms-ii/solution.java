import java.util.ArrayList;
import java.util.List;

/**
 * Definition of Interval:
 * public class Interval {
 * public int start, end;
 * public Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */

class Solution {
  public int minMeetingRooms(List<Interval> intervals) {
    int i = 1, len = intervals.size();
    if (len < 2)
      return len;
    intervals = new ArrayList<>(intervals);
    intervals.sort((a, b) -> {
      int equal = Integer.compare(a.start, b.start);
      return (equal != 0) ? equal : Integer.compare(b.end, a.end);
    });
    ArrayList<Interval> list = new ArrayList<>(len);
    list.add(new Interval(intervals.get(0).start, intervals.get(0).end));
    outer: while (i < len) {
      int start = intervals.get(i).start,
          end = intervals.get(i++).end;
      for (Interval j : list) {
        if (((start < j.end && start > j.start) || (end > j.start && end < j.end)))
          continue;
        if (start == j.start && end == j.end)
          continue;
        j.start = Math.min(start, j.start);
        j.end = Math.max(end, j.end);
        continue outer;
      }
      list.add(new Interval(start, end));
    }
    return list.size();
  }

}
