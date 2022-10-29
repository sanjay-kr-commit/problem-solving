// 2ms
class Solution1 {
    public int addDigits(int num) {
        int temp = 0 ;
        while ( num > 9 ) {
            temp = 0 ;
            while ( num != 0 ) {
                temp += num%10;
                num /=10 ;
            }
            num = temp ;
        }
        return num ;
    }
}

// 2ms
class Solution2 {
    public int addDigits(int num) {
        while ( num > 9 ) num = num/10 + num%10 ;
        return num ;
    }
}