class Solution {
    public int[] sortArray(int[] nums) {

        int min = nums[0] ;
        int max = nums[0] ;

        for ( int num : nums ) {
            min = min < num ? min : num ;
            max = max > num ? max : num ;
        }

        int len = max - min;
        int [] freq = new int[len+1];

        for ( int num : nums ) freq[num-min]++ ;

        for ( int i = 0 , index = 0 ; i <= len ; i++ ) {
            if ( freq[i] > 0 ) {
                while (freq[i] > 0) {
                    nums[index++] = min;
                    freq[i]--;
                }
            }
            min++ ;
        }

        return nums ;
    }
}