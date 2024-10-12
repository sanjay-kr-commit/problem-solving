class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length-1 ,
            minHeight = 0 , currentArea = 0 , maxArea = 0 ;
        while ( left < right ) {
            minHeight = height[left] < height[right] ? height[left] : height[right];
            currentArea = minHeight * (right - left);
            if ( currentArea > maxArea ) {
                maxArea = currentArea ;
            }
            if ( height[left] < height[right] ) left++ ;
            else right-- ;
        }
        return maxArea ;
    }
}