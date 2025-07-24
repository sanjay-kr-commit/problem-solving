import java.util.LinkedList;
import java.util.List;

// @leet start
class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    LinkedList<List<Integer>> list = new LinkedList<>();
    int[][] cache = new int[heights.length][heights[0].length];
    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        if (isPacificOceanReachable(heights, cache, new boolean[heights.length][heights[0].length], i, j,
            Integer.MAX_VALUE) &&
            isAtlanticOceanReachable(heights, cache, new boolean[heights.length][heights[0].length], i, j,
                Integer.MAX_VALUE)) {
          list.add(List.of(i, j));
        }
      }
    }
    return list;
  }

  boolean isPacificOceanReachable(int[][] heights, int[][] cache, boolean[][] path, int i, int j, int prevLength) {
    if (i >= heights.length || j >= heights[0].length)
      return false;
    if (i < 0 || j < 0)
      return true;
    if (path[i][j] || heights[i][j] > prevLength)
      return false;
    path[i][j] = true;
    if ((cache[i][j] & 1) == 1)
      return true;
    boolean isReachable;
    isReachable = isPacificOceanReachable(heights, cache, path, i + 1, j, heights[i][j]);
    isReachable = isReachable | isPacificOceanReachable(heights, cache, path, i - 1, j, heights[i][j]);
    isReachable = isReachable | isPacificOceanReachable(heights, cache, path, i, j + 1, heights[i][j]);
    isReachable = isReachable | isPacificOceanReachable(heights, cache, path, i, j - 1, heights[i][j]);
    path[i][j] = false;
    if (isReachable) {
      cache[i][j] = cache[i][j] | 1;
    }
    return isReachable;
  }

  boolean isAtlanticOceanReachable(int[][] heights, int[][] cache, boolean[][] path, int i, int j, int prevLength) {
    if (i < 0 || j < 0)
      return false;
    if (i >= heights.length || j >= heights[0].length)
      return true;
    if (path[i][j] || heights[i][j] > prevLength)
      return false;
    path[i][j] = true;
    if ((cache[i][j] & 2) == 2)
      return true;
    boolean isReachable;
    isReachable = isAtlanticOceanReachable(heights, cache, path, i + 1, j, heights[i][j]);
    isReachable = isReachable | isAtlanticOceanReachable(heights, cache, path, i - 1, j, heights[i][j]);
    isReachable = isReachable | isAtlanticOceanReachable(heights, cache, path, i, j + 1, heights[i][j]);
    isReachable = isReachable | isAtlanticOceanReachable(heights, cache, path, i, j - 1, heights[i][j]);
    path[i][j] = false;
    if (isReachable) {
      cache[i][j] = cache[i][j] | 2;
    }
    return isReachable;
  }
}
// @leet end
