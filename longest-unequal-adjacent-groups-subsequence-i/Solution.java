class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        var c = -1;
        var result = new ArrayList<String>();
        for (int i = 0; i < groups.length; i++) {
            if(c != groups[i]) {
                result.add(words[i]);
                c = groups[i];
            }
        }
        return result;
    }
}
