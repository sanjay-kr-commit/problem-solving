class Solution {

    public int maxProduct(String[] words) {

        int maxProduct = 0 ;

        // create a map with array
        // where i represent hash of a string,
        // meanwhile j which is i+1 represent length of string
        int [] map = new int[(words.length*2)];

        for ( int i = 0 , j = 0 ; i < words.length ; i++ , j += 2) {
            map[j] = genHash( words[i] ) ;
            map[j+1] = words[i].length() ;
        }

        for ( int i = 0 ; i < map.length ; i += 2 ) {
            for ( int j = 0 ; j < map.length ; j += 2 ) {
                if ( j == i || (map[i] & map[j]) != 0 ) continue;
                int product = map[i+1] * map[j+1];
                if ( product > maxProduct ) maxProduct = product;
            }
        }

        return maxProduct ;
    }

    int genHash(String s ) {
        int hash = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            hash |= 1 << ( s.charAt( i ) - 'a' );
        }
        return hash ;
    }

}