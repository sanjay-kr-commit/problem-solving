// 41 ms
// beats 20.51 %
class Solution {
    public int distributeCandies(int[] candyType) {
        int diff = 0 , max = candyType.length/2 , i = 0 , len = candyType.length-1 ;
        Arrays.sort( candyType ) ;
        while ( i < len ) {
            while ( i < len && candyType[i] == candyType[i+1] ) i++ ;
            diff++ ;
            i++ ;
        }
        if ( len > 0 && candyType[len] != candyType[len-1] ) diff++ ;
        return ( diff > max ) ? max : diff ;
    }
}

// 35 ms
// beats 83.61 %
class Solution {
    public int distributeCandies(int[] candyType) {
        int max = candyType.length/2 ;
        HashSet<Integer> unique = new HashSet<Integer>() ;
        for ( int i = 0 ; i < candyType.length ; i++ ) unique.add( candyType[i] ) ;
        return ( unique.size() > max ) ? max : unique.size() ;
    }
}

// 4ms
// beats 100%
class Solution {
  public int distributeCandies(int[] candyType) {
    // calculate constraints
    int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE ,
      diff = 0 , maxDiff = candyType.length / 2 ;
    for ( int i : candyType ) {
      if ( i < min ) min = i ;
      if ( i > max ) max = i ;
    }
    // map values so we don't count any num twice
    boolean map[] = new boolean[max-min+1] ;
    for ( int i : candyType ) {
      int j = i - min ;
      if (!map[j]) {
        map[j] = true;
        diff++ ;
        if ( diff >= maxDiff ) return maxDiff ;
      }
    }
    return diff ;
  }

}
