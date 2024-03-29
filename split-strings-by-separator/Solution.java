class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        if ( words.isEmpty() ) return new ArrayList<>() ;
        ArrayList<String> list = new ArrayList<>( words.size() ) ;
        for ( int i = 0 , len = words.size() ; i < len ; i++ ) {
            int ref = 0 ;
            for ( int j = 0 , wlen = words.get(i).length() ; j < wlen ; j++ ) {
                if ( words.get(i).charAt( j ) == separator ) {
                    if ( j - ref != 0 ) list.add( words.get( i ).substring( ref , j ) ) ;
                    ref = j+1 ;
                }
            }
            if ( words.get( i ).length() - ref != 0 ) list.add( words.get( i ).substring( ref ) ) ;
        }
        return list ;
    }
}
