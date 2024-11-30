class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1 , len ;
        for ( int i = digits.length -1 ; i > -1 ; i-- ) {
            carry += digits[i] ;
            digits[i] = carry % 10 ;
            carry /= 10 ;
        }
        if ( carry == 0 ) return digits ;
        len = digits.length + 1 ;
        int [] res = new int[ len ] ;
        res[0] = carry ;
        for ( int i = 1 ; i < len ; i++ ) {
            res[i] = digits[i-1] ;
        }
        return res;
    }
}