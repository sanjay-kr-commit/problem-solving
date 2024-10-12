import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int [] stack = new int[ asteroids.length ] ;
        int stackSize = 0 ;
        for ( int i = 0 ; i < asteroids.length ; i++ ) {
            stack[stackSize++] = asteroids[i] ;
            while ( stackSize > 1 && stack[stackSize-1] < 0 && stack[stackSize-2] > -1 ) {
                int a = Math.abs(stack[stackSize-2]) ,
                    b = Math.abs(stack[stackSize-1]) ;
                stackSize-- ;
                if ( a == b ) stackSize-- ;
                else if ( b > a ) stack[stackSize-1] = stack[stackSize] ;
            }
        }
        return Arrays.copyOf( stack , stackSize ) ;
    }
}