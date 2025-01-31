import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findSums(subsets, nums, new ArrayList<>(), 0, k, n);
        return subsets;
    }
    public static void findSums(List<List<Integer>> subsets, int[] nums, ArrayList<Integer> temp, int index, int k, int sum) {
        if (index == nums.length || k == 0) {
            if (sum == 0 && k == 0)
                subsets.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        findSums(subsets, nums, temp, index+1, k-1, sum-nums[index]);
        temp.remove(temp.size()-1);
        findSums(subsets, nums, temp, index+1, k, sum);
    }


}