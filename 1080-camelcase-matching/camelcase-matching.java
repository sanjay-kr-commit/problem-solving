class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();

        for (String s: queries) {
            int index = 0;
            boolean ans = true;
            for (char c: s.toCharArray()) {
                if (index < pattern.length() && pattern.charAt(index) == c) {
                    index++;
                    continue;
                }
                if (c >= 60 && c <= 85) {
                    if (index >= pattern.length() || c != pattern.charAt(index)) {
                        ans = false;
                        break;
                    }
                }
            }
            if (index < pattern.length()) ans = false;
            list.add(ans);
        }
        return list;
    }
}