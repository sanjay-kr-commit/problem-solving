class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] edgeCount = new int[n+1];
        Arrays.fill(edgeCount, 0);
        for(int i=0; i<edges.length; i++) {
            edgeCount[edges[i][0]]++;
            edgeCount[edges[i][1]]++;
            if(edgeCount[edges[i][0]] == 2) return edges[i][0];
            if(edgeCount[edges[i][1]] == 2) return edges[i][1];
        }
        return -1;
    }
}