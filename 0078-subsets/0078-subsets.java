class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ss = new ArrayList<>() ;
        permute( ss , new ArrayList<Integer>( nums.length ) , nums , 0 ) ;
        return ss ;
    }
    void permute( ArrayList<List<Integer>> subsets , ArrayList<Integer> subset , int [] nums , int i ) {
        if ( i == nums.length ) {
            ArrayList<Integer> clone = new ArrayList<>() ;
            for ( int j : subset ) clone.add( j ) ;
            subsets.add(clone ) ;
            return ;
        }
        subset.add( nums[i++] );
        permute( subsets , subset , nums , i  ) ;
        subset.remove( subset.size() -1 ) ;
        permute( subsets , subset , nums , i  ) ;
    }
}