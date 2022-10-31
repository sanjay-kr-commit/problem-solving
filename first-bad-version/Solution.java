/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
      // 23 ms
      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 1 , r = n , mid , bad = n ;
            while ( l < r ) {
                mid = l + ( r-l+1 ) / 2 ;
                if ( !isBadVersion( mid ) ) {
                    l = mid ;
                } else {
                    if ( bad > mid ) bad = mid ;
                    r = mid-1;
                }
            }
            return (isBadVersion( l )&&l<bad)?l:bad ;
        }
    }