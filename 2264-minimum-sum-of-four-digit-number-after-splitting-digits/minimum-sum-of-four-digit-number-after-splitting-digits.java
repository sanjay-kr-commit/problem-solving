class Solution {
    public int minimumSum(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10 ;
        }
        int one = 0 , two = 0 ;
        for (int i = 0 , j = 0 ; i < 4 && j < 10 ; i++) {
            while ( j < 10 && freq[j] == 0 ) j++ ;
            if ( i%2 == 0 ) {
                one *= 10 ;
                one += j ;
            } else {
                two *= 10 ;
                two += j ;
            }
            freq[j]-- ;
        }
        return one+two ;
    }
}