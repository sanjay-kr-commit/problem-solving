// 1ms
class Solution {
  public int[] findErrorNums(int[] nums) {
    boolean[] seen = new boolean[nums.length];
    int repeated = -1, missing = 1;
    
    for (int num : nums) {
      if (seen[num-1]) {
        repeated = num;
      }
      seen[num-1] = true;
    }
    
    for (int i = 0; i < seen.length; i++) if (!seen[i]) missing = i+1;
 
    return new int[] {repeated, missing};
  }

}

// 3 ms
class Solution {
  public int[] findErrorNums(int[] nums) {
    int len = nums.length ,
        targetSum = len * ( len + 1 ) / 2 ,
        actualSum = 0 ,
        dublicate = -1 ;
    
    for ( int i = 0 ; i < len ; i++ ) {
      int num = nums[i] ;
      num *= ( num < 0 ) ? -1 : 1 ;
      int index = num % len ;
      actualSum += num ;
      if ( nums[index] < 0 ) dublicate = num ;
      else nums[index] *= -1 ;  
    }

    return new int[] { dublicate , targetSum - ( actualSum - dublicate ) } ;
  }
}
