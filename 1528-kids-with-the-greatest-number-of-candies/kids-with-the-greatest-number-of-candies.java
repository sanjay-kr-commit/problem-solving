class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for ( int candy : candies ) max = Math.max(max, candy);
        for ( int candy : candies ) result.add( extraCandies + candy >= max ) ;
        return result ;
    }
}