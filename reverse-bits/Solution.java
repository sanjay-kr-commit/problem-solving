// 2 ms
public class Solution1 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0 ;
        for ( int i = 0 ; i < 32 ; i++ ){
            // make space of one bit at the end
            r <<= 1 ;
            // add the bit
            r |= n&1 ;
            // shift the original num
            n >>= 1 ;
        }
        return r ;
    }
}

//1 ms
// someone else's code
// we have 32 bit number 
// we keep dividing num into half and switching it to opposite end
// till the one bit
public class Solution {
    
    public int reverseBits(int num) {
        
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        
        return num;
        
    }
}