// 8 ms
class Solution1 {
    public boolean isHappy(int n) {
        int temp = 0 , re = 0 , tries = 0 ;
        do {
            temp = 0 ;
            while ( n != 0 ) {
                re = n % 10 ;
                n /= 10 ;
                temp += (re*re) ;
            }
            n = temp ;
            tries++ ;
        } while ( tries < 1000 ) ;
        return n == 1;
    }
}

// 1 ms
class Solution {
    public boolean isHappy(int n) {
        int temp = 0 , re = 0 ;
        do {
            temp = 0 ;
            while ( n != 0 ) {
                re = n % 10 ;
                n /= 10 ;
                temp += (re*re) ;
            }
            n = temp ;
        } while ( n != 1 && n != 4 ) ;
        return n == 1;
    }
}