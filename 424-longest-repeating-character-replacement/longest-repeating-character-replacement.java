class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        char[] ans = s.toCharArray();
        int n = ans.length , 
            left = 0 ,
            max = 0;
        for (int right = 0; right < n; right++) {
            freq[ans[right] - 'A']++;
            max = Math.max(max, freq[ans[right] - 'A']);
            while (right - left + 1 - max > k) {
                freq[ans[left] - 'A']--;
                left++;
            }
        }
        return ans.length - left;
    }
}