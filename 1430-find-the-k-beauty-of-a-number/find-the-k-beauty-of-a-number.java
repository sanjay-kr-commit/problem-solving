class Solution {
    public int divisorSubstrings(int num, int k) {
        int beauty = 0 ;
        int modVal = 1 ;
        for ( int i = 1 ; i < k ; i++ ) modVal *= 10 ;
        int copy = num ;
        int rev = 0 ;
        boolean zero = copy % 10 == 0 ;
        while ( copy > 0 ) {
            rev *= 10 ;
            rev += copy % 10 ;
            copy /= 10 ;
        }
        for ( int i = 1 ; i < k ; i++ ) {
            copy *= 10 ;
            copy += rev%10 ;
            rev /= 10 ;
        }
        while ( rev > 0 ) {
            copy %= modVal ;
            copy *= 10 ;
            copy += rev % 10 ;
            if (copy != 0 && num%copy==0 )beauty++ ;
            rev /= 10 ;
        }
        if ( zero ) {
            copy %= modVal ;
            copy *= 10 ;
            copy += rev%10 ;
            if (copy != 0 && num%copy==0 )beauty++ ;
        }
        return beauty ;
    }
}