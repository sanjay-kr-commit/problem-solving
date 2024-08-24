class Solution {
    public int maximum69Number (int num) {
        long reverse = 1 ;
        int index = 0 , rem , sixIndex = 0 ;
        while ( num > 0 ) {
            reverse *= 10 ;
            rem = num % 10 ;
            reverse += rem ;
            if ( rem == 6 ) sixIndex = index ;
            num /= 10 ;
            index++ ;
        }
        index-- ;
        while ( reverse > 1 ) {
            num *= 10 ;
            rem = (int) reverse % 10 ;
            num += ( index == sixIndex ) ? 9 : rem ;
            reverse /= 10 ;
            index-- ;
        }
        return num ;
    }
}