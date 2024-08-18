import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) return y - x;
        if (map.containsKey(x)) return map.get(x);
        int res = Integer.MAX_VALUE;
        //try decrease to a number dividable by 5;
        res = Math.min(minimumOperationsToMakeEqual(x/5, y) + x % 5 + 1, res);
        //try increase to a number dividable by 5;
        res = Math.min(minimumOperationsToMakeEqual(x/5 + 1, y) + (5 - x % 5) + 1, res);
        //try decrease to a number dividable by 11;
        res = Math.min(minimumOperationsToMakeEqual(x/11, y) + x % 11 + 1, res);
        //try increase to a number dividable by 11;
        res = Math.min(minimumOperationsToMakeEqual(x/11 + 1, y) + (11 - x % 11) + 1, res);
        //try decrease to y directly.
        res = Math.min(x - y, res);
        map.put(x, res);
        return res;
    }
}