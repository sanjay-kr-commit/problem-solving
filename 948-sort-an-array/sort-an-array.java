class Solution {

    void merge(
            int [] nums , int l , int m , int r
    ) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = nums[l + i];
        
        for (int j = 0; j < n2; ++j) R[j] = nums[m + 1 + j];
        
        int i = 0, j = 0;

        int k = l;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) nums[k++] = L[i++];
            else nums[k++] = R[j++];
        }

        while (i < n1) nums[k++] = L[i++];
         
        while (j < n2) nums[k++] = R[j++];
        
    }

    void sort(
            int[] nums , int l , int r
    ) {
        if ( l < r ) {
            int m = l + (r - l) / 2;
            sort( nums, l, m);
            sort( nums, m + 1, r);
            merge( nums, l, m, r);
        }
    }

    public int[] sortArray(int[] nums) {
        sort( nums , 0 , nums.length -1 );
        return nums ;
    }
}