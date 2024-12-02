class Solution {
    public boolean isHappy(int n) {
        int sum, temp ;
        while ( n != 1 && n != 4 ) {
            sum = 0 ;
            while ( n != 0 ) {
                temp = n % 10 ;
                n /= 10 ;
                sum += temp * temp ;
            }
            n = sum ;
        }
        return n == 1 ;
    }
}