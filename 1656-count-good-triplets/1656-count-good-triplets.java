class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0 ;
        for ( int i = 0, leni = arr.length-2; i < leni ; i++ ) {
            for ( int j = i+1 , lenj = leni+1 ; j < lenj ; j++ ) {
                if ( Math.abs( arr[i]-arr[j] ) > a ) continue;
                for ( int k = j+1 , lenk = lenj+1 ; k < lenk ; k++ ) {
                    if ( Math.abs( arr[k]-arr[j] ) > b || Math.abs( arr[k]-arr[i] ) > c  ) continue;
                    count++;
                }
            }
        }
        return count ;
    }
}