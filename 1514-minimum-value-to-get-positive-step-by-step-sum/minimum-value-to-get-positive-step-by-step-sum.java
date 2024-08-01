class Solution {
    public int minStartValue(int[] nums) {
        int minStart = nums[0], sum = nums[0];
        for(int i = 1; i <nums.length; i++){
            sum += nums[i];
            minStart = Math.min(sum, minStart);
        }
        return (minStart > 0)? 1 : Math.abs(minStart) + 1;
    }
}