class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int smaller = 0 , larger = 0 , pivots = 0 ;
        for ( int i : nums ) {
            smaller += ( i < pivot ) ? 1 : 0 ;
            larger += ( i > pivot ) ? 1 : 0 ;
            pivots += ( i == pivot ) ? 1 : 0 ;
        }
        int [] result = new int[nums.length];
        int i = 0 , j = smaller , k = smaller+pivots ;
        for ( int num : nums ) {
            if ( num == pivot ) result[j++] = num ;
            else if ( num > pivot ) result[k++] = num ;
            else result[i++] = num ;
        }
        return result;
    }
}