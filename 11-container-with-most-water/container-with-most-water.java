class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for ( int l = 0 , r = height.length - 1 ; l < r ; ) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * ((r+1) - (l+1)));
            if ( height[l] < height[r] ) l++ ;
            else r-- ;
        }
        return maxArea ;
    }
}