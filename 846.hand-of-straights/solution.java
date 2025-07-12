import java.util.HashMap;
import java.util.PriorityQueue;

// @leet start
class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length == 0)
      return true;
    if (hand.length % groupSize != 0)
      return false;
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i : hand) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      pq.add(i);
    }
    while (!pq.isEmpty()) {
      int start;
      do {
        start = pq.poll();
      } while (map.get(start) == 0 && !pq.isEmpty());
      if (map.get(start) == 0)
        break;
      for (int i = start, len = i + groupSize; i < len; i++) {
        if (!map.containsKey(i))
          return false;
        if (map.get(i) == 0)
          return false;
        map.put(i, map.get(i) - 1);
      }
    }
    return true;
  }
}

// @leet end
