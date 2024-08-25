class Solution {
    public int minTimeToType(String word) {
        int counter = 0;
        char previous = 'a';
        for (char c : word.toCharArray()) {
            counter += move(previous, c) + 1;
            previous = c;
        }
        return counter;
    }

    private int move(char a, char b) {
        int diff = Math.abs(b - a);
        return Math.min(diff, 26 - diff);
    }
}