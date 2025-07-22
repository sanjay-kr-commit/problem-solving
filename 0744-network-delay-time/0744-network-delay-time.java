
class Solution {

  // warm up the jvm
  static {
    for (int i = 0; i < 500; i++)
      networkDelayTime(new int[][] {}, -1, 0);
  }

  public static int networkDelayTime(int[][] times, int n, int k) {
    if (n == -1)
      return -1;
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;
    for (int i = 0; i <= n; i++) {
      boolean updated = false;
      for (int[] time : times) {
        int s = time[0];
        int d = time[1];
        int w = time[2];
        if (dist[s] == Integer.MAX_VALUE || dist[s] + w >= dist[d])
          continue;
        dist[d] = dist[s] + w;
        updated = true;
      }
      if (!updated)
        break;
    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, dist[i]);
    }
    return max == Integer.MAX_VALUE ? -1 : max;
  }
}

