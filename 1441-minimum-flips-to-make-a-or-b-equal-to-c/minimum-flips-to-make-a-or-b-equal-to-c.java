class Solution {
    public int minFlips(int a, int b, int c) {
        int bitChanged = 0 ;
        for ( int i = 0 , observableBit ; i < 32 ; i++ ) {
            observableBit = 1 << i ;
            if ( ( c & observableBit ) == observableBit ) {
                if ( ( a & observableBit) != observableBit && ( b & observableBit) != observableBit ) bitChanged++ ;
                continue;
            } 
            if ( ( a & observableBit ) == observableBit ) bitChanged++ ;
            if ( ( b & observableBit ) == observableBit ) bitChanged++ ;
        }
        return bitChanged ;
    }
}