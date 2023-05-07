import java.awt.PrintJob;

// 1ms
class Solution {
  
  private int maxi(int[] a,int n) {
    int max=(int)-9999999;
    int f=-1;
    for(int i=0;i<n;i++) {
      if(max<=a[i]){
        max=a[i];
        f=i;
      }
    }
    a[f]=(int)-9999999;
    return max;
  }

  private int min(int[] a,int n){
    int max=(int)999999;
    int f=-1;
    for(int i=0;i<n;i++) {
      if(a[i]!=-9999999) {
        if(max>=a[i]) {
          max=a[i];
          f=i;
        }
      }
    }
    a[f]=(int)999999;
    return max;
  }
  
  public int maximumProduct(int[] a) {
    int n=a.length;
    int aa=maxi(a,n);
    int b=maxi(a,n);
    int c=maxi(a,n);
    if(n==3) {
      return aa*b*c;
    }
    int x=min(a,n);
    int y=min(a,n);
    if(n==4) {
      y=c;
    }
    return Math.max(aa*b*c,aa*x*y);
  }
}

// 2ms
class Solution {
  public int maximumProduct(int[] nums) {
    int common1 = max( nums ) ,
        common2 = max( nums ) ,
        common3 = max( nums ) ,
        max = common1 * common2 * common3 ,
        len = nums.length ,
        min = common1 ;
    if ( len == 3 ) return max ;
    if ( len == 4 ) {
      min *= common3 * min( nums ) ;
    } else {
      min *= min( nums ) * min( nums ) ;
    }
    return ( min < max ) ? max : min ;
  }
  
  private int min( int[] nums ) {
    int min = (int) 9999999 ;
    int selected = -1 ;
    for ( int i = 0 ; i < nums.length ; i++ ) {
      if ( nums[i] != -9999999 && nums[i] < min ) {
        min = nums[i] ;
        selected = i ;
      }
    }
    nums[selected] = 9999999 ;
    return min ;
  }

  private int max( int[] nums ) {
    int max = (int)-9999999 ;
    int selected = -1 ;
    for ( int i = 0 ; i < nums.length ; i++ ) {
      if ( nums[i] != 9999999 && nums[i] > max ) {
        max = nums[i] ;
        selected = i ;
      }
    }
    nums[selected] = -9999999 ;
    return max ;
  }

}

// 3ms
class Solution {
  public int maximumProduct(int[] nums) {
    int min = Integer.MIN_VALUE , max = Integer.MAX_VALUE ;
    int [] selected = new int[] { max , max , min , min , min } ;
    
    for ( int i : nums ) {
    
      if ( i < selected[0] ) {
        selected[1] = selected[0] ;
        selected[0] = i ;
      } else if ( i < selected[1] ) selected[1] = i ;
    
      if ( i > selected[2] ) {
        selected[4] = selected[3] ;
        selected[3] = selected[2] ;
        selected[2] = i ;
      } else if ( i > selected[3] ) {
        selected[4] = selected[3] ;
        selected[3] = i ; 
      } else if ( i > selected[4] ) selected[4] = i ;
    
    }
    min = selected[0] * selected[1] * selected[2] ;
    max = selected[2] * selected[3] * selected[4] ;
    return ( min > max ) ? min : max ;
  }
}
