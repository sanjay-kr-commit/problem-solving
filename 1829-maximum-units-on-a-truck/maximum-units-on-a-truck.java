class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int [] units = new int[1001];
        for ( int [] container : boxTypes ) units[container[1]] += container[0];
        int index = 1000 , unitShipped = 0 ;
        while ( index > 0 && truckSize > 0 ) {
            while ( index > 0 && units[index] == 0 ) index-- ;
            if ( index > 0 ) {
                int min = Math.min(units[index], truckSize);
                truckSize -= min ;
                unitShipped += index * min ;
                units[index] -= min ;
            }
        }
        return unitShipped ;
    }
}