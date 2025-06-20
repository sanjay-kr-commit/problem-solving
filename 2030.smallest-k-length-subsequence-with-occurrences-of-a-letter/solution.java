import java.util.Comparator;
import java.util.PriorityQueue;

// @leet start
class Solution {
  public String smallestSubsequence(String s, int k, char letter, int repetition) {
    boolean[] use = new boolean[s.length()];
    int offset = -1;
    for (int i = 0, len = s.length(), min = Integer.MAX_VALUE; i < len; i++) {
      char c = s.charAt(i);
      if (c < min) {
        min = c;
        offset = i - 1;
      } else {
        int j = i - 1;
        while (j > offset && (!use[j] || s.charAt(j) > c)) {
          use[j] = false;
          j--;
        }
      }
      use[i] = true;
    }
    offset++;
    int count = 0;
    for (int i = 0; i < offset; i++)
      use[i] = false;
    offset--;
    int letterCount = repetition;
    // count
    for (int i = 0; i < use.length; i++) {
      if (use[i]) {
        count++;
        if (s.charAt(i) == letter)
          letterCount--;
      }
    }
    // add letter if absent
    for (int i = use.length - 1; i > -1 && letterCount > 0; i--) {
      if (!use[i] && s.charAt(i) == letter) {
        letterCount--;
        count++;
        use[i] = true;
      }
    }
    letterCount = 0;
    int start = 0;
    while (start < use.length && !use[start])
      start++;
    int end = use.length - 1;
    while (end > -1 && !use[end])
      end--;
    start--;
    for (int lastTrue = end; start < end; end--) {
      if (!use[end]) {
        if (s.charAt(end) > s.charAt(lastTrue))
          continue;
        use[end] = true;
        count++;
        lastTrue = end;
      } else
        lastTrue = end;
    }
    for (int i = 0; i < use.length; i++) {
      if (use[i] && s.charAt(i) == letter)
        letterCount++;
    }
    // check if string length is greater then k
    for (int i = use.length - 1; i > -1 && count > k; i--) {
      if (use[i] && (s.charAt(i) != letter || letterCount > repetition)) {
        use[i] = false;
        if (s.charAt(i) == letter)
          letterCount--;
        count--;
      }
    }

    // check if string length is smaller then k
    while (count < k) {
      end = use.length - 1;
      while (end > -1 && use[end])
        end--;
      if (end == -1)
        break;
      PriorityQueue<pair> queue = new PriorityQueue<>(
          Comparator.comparingInt((pair a) -> a.c).thenComparingInt(a -> a.index));
      while (end > -1 && !use[end]) {
        queue.add(new pair(s.charAt(end), end));
        end--;
      }
      use[queue.poll().index] = true;
      count++;
    }
    // for (int i = use.length - 1; i > -1 && count < k; i--) {
    // if (!use[i]) {
    // count++;
    // use[i] = true;
    // }
    // }
    char[] ans = new char[k];
    int filled = 0;
    for (int i = 0; i < use.length && filled < k; i++) {
      if (use[i])
        ans[filled++] = s.charAt(i);
    }
    return new String(ans);
  }

  static class pair {
    char c;
    int index;

    pair(char c, int index) {
      this.c = c;
      this.index = index;
    }
  }

  String print(String s, boolean[] use) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (use[i]) {
        sb.append(s.charAt(i)).append(",");
        System.out.print(s.charAt(i) + ",");
      }
    }
    System.out.println();
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().smallestSubsequence(
            "hjjhhhmhhwhz",
            6,
            'h',
            5));
    System.out.println("hhhhhh\n");
    System.out.println(
        new Solution().smallestSubsequence(
            "xwvvsrvvihvvvebvavfhivvo",
            13,
            'v',
            11

        ));
    System.out.println("vvrvvhvvvvvvv\n");
    System.out.println(
        new Solution().smallestSubsequence(
            "cdjjmnqqrrvwwwxyydvrqqqnhged",
            21,
            'd',
            2

        ));
    System.out.println("cdjjmnqqrrdvrqqqnhged\n");
    System.out.println(new Solution().smallestSubsequence(
        "mmmxmxymmm",
        8,
        'm',
        4

    ));
    System.out.println(
        "mmmmxmmm\n");
    System.out.println(
        new Solution().smallestSubsequence(
            "aaabbbcccddd",
            3,
            'b',
            2));
    System.out.println("abb\n");
    System.out.println(
        new Solution().smallestSubsequence("leet", 3, 'e', 1));
    System.out.println("eet\n");
    System.out.println(
        new Solution().smallestSubsequence("leetcode", 4, 'e', 2));
    System.out.println("ecde\n");
    System.out.println(
        new Solution().smallestSubsequence("bb", 2, 'b', 2));
    System.out.println("bb\n");
  }
}
// @leet end
