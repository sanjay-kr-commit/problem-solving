import java.util.ArrayList;
import java.util.List;

class Solution {
    private void addAllSubsetsUsingFirstN(int subSize, List<List<Integer>> subsets, int[] nums) {
        int num = nums[subSize - 1];
        int numSubsets = subsets.size();
        for (int i = 0; i < numSubsets; i++) {
            List<Integer> prevSubset = subsets.get(i);
            List<Integer> subset = new ArrayList<>(prevSubset.size() + 1);
            subset.addAll(prevSubset);
            subset.add(num);
            subsets.add(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>(1 << n);
        subsets.add(new ArrayList<>(0));
        for (int subSize = 1; subSize <= n; subSize++) {
            addAllSubsetsUsingFirstN(subSize, subsets, nums);
        }
        return subsets;
    }
}