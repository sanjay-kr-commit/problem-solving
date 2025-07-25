class Solution {
    private int n;
    private int m;
    private boolean[][] vis;
    private int[][] hs;
    public int minimumEffortPath(int[][] hs) {
        this.hs = hs;
        n = hs.length;
        m = hs[0].length;
        int l = 0;
        int r = 1000000;
        int res = r, m;
        while(l <= r){
            m = (l + r) / 2;
            if(rec(m)){
                res = Math.min(res, m);
                r = m - 1;
            } else 
                l = m + 1;
        }
        return res;
    }

    private boolean rec(int k){
        vis = new boolean[n][m];
        return hasPath(0, 0, k);
    }

    private boolean hasPath(int r, int c, int k){
        if(r == n - 1 && c == m - 1)
            return true;

        vis[r][c] = true;
        if(c + 1 < m && !vis[r][c + 1] && Math.abs(hs[r][c + 1] - hs[r][c]) <= k)
            if(hasPath(r, c + 1, k))
                return true;
                
        if(r + 1 < n && !vis[r + 1][c] && Math.abs(hs[r + 1][c] - hs[r][c]) <= k)
            if(hasPath(r + 1, c, k))
                return true;
                
        if(c - 1 >= 0 && !vis[r][c - 1] && Math.abs(hs[r][c - 1] - hs[r][c]) <= k)
            if(hasPath(r, c - 1, k))
                return true;
                
        if(r - 1 >= 0 && !vis[r - 1][c] && Math.abs(hs[r - 1][c] - hs[r][c]) <= k)
            if(hasPath(r - 1, c, k))
                return true;

        return false;
    }
}