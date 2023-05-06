class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = n , len = flowerbed.length ;
    for ( int i = 0 ; i < len ; i++ ) {
      if ( i > 0 && flowerbed[i-1] == 1 ) continue ;
      if ( i < len-1 && flowerbed[i+1] == 1 ) continue ;
      if ( flowerbed[i] == 1 ) continue ;
      count-- ;
      flowerbed[i]++ ;
    }
    return count <= 0 ;
  }
}
