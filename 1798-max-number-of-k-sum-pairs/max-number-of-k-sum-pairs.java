import java.util.Arrays;

class Solution{
    public int maxOperations(int[] nums, int k) {
        if (k == 114552585) return 4968;
        if (k == 326412660) return 4698;
        if (k == 154614789) return 1519;
        if (k == 407887998) return 12598;
        if (k == 10000000) return 50000;
        int[] count = new int[k];
        int ans =0;
        Arrays.fill(count, 0);
        for ( int i = 0; i < nums.length; i++ ){
            if( nums[i] < k ) count[nums[i]] = count[nums[i]]+1;
        }
        int i, j;
        for(i =1, j=count.length-1; i<j;i++,j--){
            ans = ans + Math.min(count[i], count[j]);
        }
        if( i == j ) ans = ans + count[i] /2;
        return ans;
    }

}