class Solution {
    public int trap(int[] height) {
        int trappedWater = 0 , pointer = 0 ,
                stackPointer = 0 ,
                len = height.length ,
                maxHeight = 0 ,
                minHeight = 0 ;
        int [] stack = new int[height.length];
        while ( pointer < len ) {
            if ( height[pointer] < maxHeight ) stack[stackPointer++] = height[pointer];
            if ( height[pointer] > minHeight && height[pointer] <= maxHeight ) {
                // level the cavities to the new max
                for ( int i = 0 ; i < stackPointer ; i++ ) {
                    if ( height[pointer] > stack[i] ) {
                        trappedWater += height[pointer] - stack[i];
                        stack[i] = height[pointer];
                    }
                }
                minHeight = height[pointer];
            }
            if ( height[pointer] > maxHeight ) {
                while ( stackPointer > 0 ) {
                    trappedWater += maxHeight - stack[--stackPointer] ;
                }
                stack[stackPointer++] = height[pointer];
                maxHeight = height[pointer];
                minHeight = height[pointer];
            }
            minHeight = Math.min(minHeight, height[pointer]);
            pointer++ ;
        }
        return trappedWater;
    }
}
