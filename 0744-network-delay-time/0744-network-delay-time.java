class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<LinkedList<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n + 1; i++)
            graph.add(new LinkedList<>());
        for (int[] time : times)
            graph.get(time[0]).add(time);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(k) ;
        // check if all the nodes are accessible from k node
        for (int[] node : graph.get(k))
            dfs(graph, node, visited, new HashSet<>());
        if (visited.size() != n)
            return -1;
        visited.clear();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        for (int[] node : graph.get(k)) {
            pq.add(node);
        }
        int time = 0;
        visited.add(k);
        while (!pq.isEmpty()) {
            int[] vertex = pq.poll();
            if (visited.contains(vertex[1]))
                continue;
            visited.add(vertex[1]);
            time = vertex[2];
            for (int[] node : graph.get(vertex[1])) {
                if (visited.contains(node[1]))
                    continue;
                node[2] = time + node[2];
                pq.add(node);
            }
        }
        return time;
    }

    void dfs(List<LinkedList<int[]>> graph, int[] node, HashSet<Integer> visited, HashSet<Integer> path) {
        if (path.contains(node[1]))
            return;
        path.add( node[1] ) ;
        visited.add(node[1]);
        for (int[] n : graph.get(node[1])) {
            dfs(graph, n, visited,path);
        }
    }

}
