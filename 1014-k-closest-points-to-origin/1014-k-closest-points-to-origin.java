import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    static class pair {
        double distance ;
        int [] point ;
        pair(double distance, int [] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int [][] closest = new int[k][];
        PriorityQueue<pair> priorityQueue = new PriorityQueue<>( points.length , Comparator.comparingDouble(o -> o.distance)) ;
        for ( int [] point : points ) {
            priorityQueue.offer(
                new pair( distance(point) , point)
            ) ;
        }
        int i = 0 ;
        while ( i < k && !priorityQueue.isEmpty() ) {
            pair pair = priorityQueue.poll();
            closest[i++] = pair.point ;
        }
        return closest ;
    }

    double distance(int[] point) {
        return Math.sqrt(
            (point[0] * point[0]) + (point[1] * point[1])
        ) ;
    }
}