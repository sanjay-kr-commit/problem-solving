class DetectSquares { 
    int[][] cntPoints = new int[1001][1001];
    List<int[]> points = new ArrayList<>();

    public void add(int[] p) {
        cntPoints[p[0]][p[1]] += 1;
        points.add(p);
    }

    public int count(int[] p1) {
        int x1 = p1[0], y1 = p1[1], ans = 0;
        for (int[] p3 : points) {
            int x3 = p3[0], y3 = p3[1];
            if (Math.abs(x1-x3) == 0 || Math.abs(x1-x3) != Math.abs(y1-y3))
                continue;
            ans += cntPoints[x1][y3] * cntPoints[x3][y1];
        }
        return ans;
    }
}