class Solution {
    public int countSymmetricIntegers(int low, int high) {
        high++ ;
        int count = 0 ;
        for ( int i = low ; i < high ; i++ ) {
            if ( isSymmetric(i) ) count++;
        }
        return count ;
    }

    boolean isSymmetric(int n) {
        int places = 0 , temp = n ;
        while ( temp > 0 ) {
            places++ ;
            temp = temp / 10 ;
        }
        if ( places % 2 == 1 ) return false ;
        int firstHalf = 0 , secondHalf = 0 ;
        places /= 2 ; temp = n ;
        for ( int i = 0 ; i < places ; i++ ) {
            firstHalf += temp % 10 ;
            temp /= 10 ;
        }
        for ( int i = 0 ; i < places ; i++ ) {
            secondHalf += temp % 10 ;
            temp /= 10 ;
        }
        return firstHalf == secondHalf ;
    }

}