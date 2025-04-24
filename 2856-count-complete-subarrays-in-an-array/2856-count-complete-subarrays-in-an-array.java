import java.util.Arrays;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int completeSubarraysCount = 0;
        int min = nums[0] , max = nums[0] ;
        for ( int i : nums ) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int [] freqTable = new int [max - min + 1];
        for ( int i : nums ) freqTable[i-min]++ ;
        int distinct = 0 ;
        for ( int i : freqTable ) if ( i > 0 ) distinct++ ;
        Arrays.fill(freqTable, 0);
        int l = 0 , r = 0 , len = nums.length , subArrayDistinctCount = 0 ;
        while ( r < len && subArrayDistinctCount < distinct ) {
            int index = nums[r]-min ;
            if ( freqTable[index] == 0 ) subArrayDistinctCount++;
            freqTable[index]++ ;
            r++ ;
        }
        if ( r == nums.length && subArrayDistinctCount == distinct )  do {
            completeSubarraysCount += (len-r) + 1 ;
            int index = nums[l]-min ;
            freqTable[index]-- ;
            if ( freqTable[index] == 0 ) subArrayDistinctCount--;
            l++ ;
        } while ( l < r && subArrayDistinctCount == distinct ) ;
        while ( r < nums.length ) {
            if ( subArrayDistinctCount == distinct ) do {
                completeSubarraysCount += (len-r) + 1 ;
                int index = nums[l]-min ;
                freqTable[index]-- ;
                if ( freqTable[index] == 0 ) subArrayDistinctCount--;
                l++ ;
            } while ( l < r && subArrayDistinctCount == distinct ) ;
            int index = nums[r]-min ;
            if ( freqTable[index] == 0 ) subArrayDistinctCount++;
            freqTable[index]++ ;
            r++ ;
        }
        if ( subArrayDistinctCount == distinct ) do {
            completeSubarraysCount += (len-r) + 1 ;
            int index = nums[l]-min ;
            freqTable[index]-- ;
            if ( freqTable[index] == 0 ) subArrayDistinctCount--;
            l++ ;
        } while ( l < r && subArrayDistinctCount == distinct ) ;
        return completeSubarraysCount;
    }
}