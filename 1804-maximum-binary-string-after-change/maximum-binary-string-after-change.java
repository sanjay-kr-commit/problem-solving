class Solution {
    public String maximumBinaryString(String binary) {
        int index = binary.indexOf('0');
        if(index < 0)
            return binary;

        int ones = 0, n = binary.length();
        
        while(index < n)
            ones += binary.charAt(index++) - '0';

        StringBuilder result = new StringBuilder("1".repeat(n));
        result.setCharAt( n - ones -1, '0');
        return result.toString();
    }
}