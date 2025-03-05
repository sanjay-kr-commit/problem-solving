class Solution {
    public long coloredCells(int n) {
        long colored = 1 ;
        int count = 0 ;
        n-- ;
        while ( count < n ) {
            colored += count * 4L;
            colored += 4 ;
            count++ ;
        }
        return colored ;
    }
}