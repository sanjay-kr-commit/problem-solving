class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0 ;
        for ( int i : nums ) ans |= i ;
        return ans;
    }
}