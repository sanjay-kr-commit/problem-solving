class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = n ;
        for ( int i = 0 ; i < flowerbed.length ; i++ ) {
            if ( flowerbed[i] == 1 ) continue;
            if ( i > 0 && flowerbed[i-1] == 1 ) continue;
            if ( i < flowerbed.length-1 && flowerbed[i+1] == 1 ) continue;
            count-- ;
            flowerbed[i]++ ;
        }
        return count <= 0 ;
    }
}