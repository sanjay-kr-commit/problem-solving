class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1 || encodedText.isEmpty() ) return encodedText;
        int len = encodedText.length();
        int col = len/rows;
        char[] result = new char[len];
        int resultInd = 0;
        for(int i = 0; i < col;i++) {
            int index = i;
            int x = Math.min(rows, col-i);
            for(int j = 0; j < x ; j++) {
                result[resultInd++] = encodedText.charAt(index);
                index+=col+1;
            }

        }
        int j = len-1;
        while(result[j] == ' ' || result[j] == 0) j--;
        return String.copyValueOf(result, 0, j+1);
    }
}