import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int [] result = new int[spells.length];
        int l = 0 , r = potions.length , m ;
        boolean isPrior = false;
        for ( int i = 0 ; i < spells.length ; i++ ) {
            if ( isPrior ) {
                if ( spells[i] == spells[i-1] ) {
                    result[i] = result[i-1] ;
                    continue;
                } else if ( spells[i-1] > spells[i] ) {
                    r = potions.length ;
                } else  {
                    r = l ;
                    l = 0 ;
                }
            } else isPrior = true;
            long x = success / spells[i];
            if ( success % spells[i] != 0 ) x++ ;
            while ( l < r ) {
                m = l + ( r - l ) / 2 ;
                if ( potions[m] == x ) {
                    l = m ;
                    break;
                } else if ( potions[m] > x ) r = m-1 ;
                else l = m+1 ;
            }
            if ( l < potions.length ) while ( l > 0 && potions[l] > x  ) l-- ;
            if ( l > -1 ) while ( l < potions.length-1 && potions[l] < x ) l++ ;
            r = l ;
            if ( l < potions.length ) while ( l > -1 && potions[l] == potions[r] ) l-- ;
            l += (l == potions.length) ? 0 : 1 ;
            result[i] = potions.length - l ;
        }
        return result ;
    }
}