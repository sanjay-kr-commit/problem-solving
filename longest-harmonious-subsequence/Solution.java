// 14 ms
class Solution {
  public int findLHS(int[] nums) {
    int longest = 0 ,
        len = nums.length ,
        i = 0 ;
    
    Arrays.sort( nums ) ;
    
    while ( i < len ) {
    
      int j = i , k ;
    
      while ( j < len && nums[j] == nums[i] ) j++ ;

      // check if no other distinct num was found or gap between 
      // value of i and j is greater than 1 
      if ( j == len || nums[j] != nums[i]+1 ) {
        i = j ;
        continue ;
      }

      k = j ;
      
      while ( k < len && nums[k] == nums[j] ) k++ ;
      
      int diff = k - i ;

      if ( diff > longest ) longest = diff ;
      
      i = j ;
    }

    return longest ;
  }

}

// 20 ms 
class Solution {
  public int findLHS(int[] nums) {
    int longest = 0 ;
    HashMap<Integer,Integer> map = new HashMap<>() ;
    for ( int i : nums ) map.put( i , (( map.containsKey( i ) ) ? map.get(i) : 0 )+1 ) ;
    for ( int i : map.keySet() ) {
      if ( map.containsKey(i+1) ) {
        int diff = map.get(i) + map.get(i+1) ;
        if ( longest < diff ) longest = diff ;
      }
    }
    return longest ;
  }
}
