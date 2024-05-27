import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]) {
                int prev = stack.pollLast();
                answer[prev] = i - prev;
            }
            stack.add(i);
        }

        return answer;
    }
}