// 0ms
class Solution {
    public int[] plusOne(int[] digits) {
        int pointer = digits.length -1 ;
        while ( pointer > -1 ) {
            digits[pointer] = (digits[pointer]+1) %10 ;
            if ( digits[pointer] != 0 ) break ;
            pointer-- ;
        }
        if ( pointer == -1 ) {
            int[] nums = new int[digits.length+1] ;
            nums[0] = 1 ;
            for ( int i = 1 ; i < nums.length ; i++ ) nums[i] = 0 ;
            return nums ;
        }
        return digits ;
    }
}