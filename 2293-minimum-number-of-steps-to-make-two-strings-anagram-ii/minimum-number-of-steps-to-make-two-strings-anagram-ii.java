class Solution {
    public int minSteps(String s, String t) {

        int arr[]=new int[26];
        int n=s.length();
        int m=t.length();
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']++;

        }
        for(int i=0;i<m;i++)
        {
            arr[t.charAt(i)-'a']--;

        }
        int ans=0;
        for(int i=0;i<26;i++)
        {
            ans+=Math.abs(arr[i]);
        }
        return ans;
    }
}