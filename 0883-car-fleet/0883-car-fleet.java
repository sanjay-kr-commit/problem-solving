import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] zipped = new Pair[position.length];
        for ( int i = 0 ; i < position.length ; i++ ) {
            zipped[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(zipped, (o1, o2) ->
                Integer.compare(o2.x, o1.x)
                );
        Stack<Double> stack = new Stack<>();
        for ( Pair pair : zipped ) {
            double time = (double) ( target - pair.x ) / pair.y ;
            if ( stack.isEmpty() || time > stack.peek() ) stack.push(time);
        }
        return stack.size() ;
    }
}
