class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if ( k == 0 ) return result;
        if ( k < 0 ) {
            k *= -1 ;
            int sum = 0 ;
            for ( int i = 0 ; i < Math.min( code.length , k ) ; i++ ) {
                sum += code[i] ;
            }
            for ( int i = k , len = code.length ; i < code.length+k ; i++ ) {
                result[i%len] = sum ;
                sum -= code[ (i-k)%len ] ;
                sum += code[i%len] ;
            }
        } else {
            int sum = 0 ;
            for ( int i = code.length-1 ; i > Math.max(code.length-k-1 , -1 ) ; i-- ) {
                sum += code[i] ;
            }
            for ( int i = code.length-1 , len = code.length ; i > -1 ; i-- ) {
                int index = (i-k) % len ;
                if ( index < 0 ) index = len + index ;
                result[ index ] = sum ;
                sum -= code[i%len] ;
                sum += code[index] ;
            }
        }
        return result ;
    }
}