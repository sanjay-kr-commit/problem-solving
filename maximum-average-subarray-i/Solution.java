// 3ms
class Solution {

  public double findMaxAverage(int[] nums, int k) {
    int sum = 0 , max = Integer.MIN_VALUE ;
    for ( int i = 0 ; i < k ; i++ ) sum += nums[i] ;
    if ( max < sum ) max = sum ;
    for ( int i = k ; i < nums.length ; i++ ) {
      sum += nums[i] - nums[i-k] ;
      if ( max < sum ) max = sum ;
    }
    return ((double) max / k) ;
  }

}

// 5ms
class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int sum = 0 ;
    int initial = nums[0] ;
    double avg ;
    for ( int i = 0 ; i < k ; i++ ) sum += nums[i] ;
    avg = (double)sum / (double)k ;
    for ( int i = k ; i < nums.length ; i++ ) {
      sum -= initial ;
      sum += nums[i] ;
      initial = nums[i-k+1] ;
      double newAvg =  (double)sum / (double)k ;
      if ( avg < newAvg ) avg = newAvg ;
    }
    return avg ;
  }
}
