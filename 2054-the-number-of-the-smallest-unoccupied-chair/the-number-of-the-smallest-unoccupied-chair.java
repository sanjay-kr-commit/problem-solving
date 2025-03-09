import java.util.*;
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = times.length, max = 0, counter = 0;
        for(int[] time : times) max = Math.max(max, time[1]);
        List<Integer>[] timeline = new ArrayList[max + 1];
        for( int i = 0; i < n; i++ ){
            int[] time = times[i];
            int arrive = time[0], leave = time[1];
            if( timeline[arrive] == null ) timeline[arrive] = new ArrayList<>();
            if( timeline[leave] == null ) timeline[leave] = new ArrayList<>();
            timeline[arrive].add(i);
            timeline[leave].add(i);
        }
        for (List<Integer> integers : timeline) {
            if (integers == null) continue;
            int[] tracker = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                if (!map.containsKey(integers.get(j))) continue;
                tracker[j] = 1;
                pq.offer(map.get(integers.get(j)));
                map.remove(integers.get(j));
                counter--;
            }
            for (int j = 0; j < integers.size(); j++) {
                if (tracker[j] == 1) continue;
                int person = integers.get(j);
                if (!pq.isEmpty()) map.put(person, pq.poll());
                else map.put(person, counter);
                counter++;
                if (person == targetFriend) return map.get(person);
            }
        }
        return -1;
    }
}