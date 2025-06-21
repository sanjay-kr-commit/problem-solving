// @leet start

import java.util.PriorityQueue;

class Solution {
  public int maximumProduct(int[] nums, int k) {
    int mod = 1000000007;
    PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
    for (int num : nums)
      pq.offer(num);
    for (; k > 0; k--) {
      pq.offer(pq.poll() + 1);
    }
    int product = 1;
    while (!pq.isEmpty()) {
      product = (int) (((long) product * pq.poll()) % mod);
    }
    return product;
  }

}

// @leet end
