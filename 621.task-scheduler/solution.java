import java.util.HashMap;
import java.util.PriorityQueue;

// @leet start

class Solution {

  class pair {
    int task;
    int count = 0;
  }

  public int leastInterval(char[] tasks, int n) {
    int time = 0;
    PriorityQueue<pair> task = new PriorityQueue<pair>((o1, o2) -> Integer.compare(o2.count, o1.count));
    int[] freq = new int[26];
    for (char c : tasks)
      freq[c - 'A']++;
    for (int i = 0; i < 26; i++) {
      if (freq[i] == 0)
        continue;
      pair p = new pair();
      p.count = freq[i];
      p.task = i;
      task.add(p);
    }
    HashMap<Integer, pair> cooldown = new HashMap<>();
    int taskCount = tasks.length;
    while (taskCount > 0) {
      if (!task.isEmpty()) {
        pair p = task.poll();
        if (p.count > 1) {
          p.count--;
          cooldown.put(time + n, p);
        }
        taskCount--;
      }
      if (cooldown.containsKey(time))
        task.add(cooldown.get(time));
      time++;
    }
    return time;
  }
}
// @leet end
