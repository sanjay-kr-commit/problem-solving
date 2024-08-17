import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        StringBuffer buffer = new StringBuffer(word);
        for ( int i = 0 ; i < word.length() ; i++ ) if ( word.charAt( i ) < '0' || word.charAt( i ) > '9' ) buffer.setCharAt( i , ' ');
        Set<String> count = new HashSet<>();
        buffer.append( ' ' ) ;
        int index = 0 , len = buffer.length() ;
        boolean containsDigit = false;
        while ( index < len ) {
            while ( index < len && buffer.charAt( index ) == ' ' ) index++ ;
            int startIndex = index ;
            while ( index < len && buffer.charAt( index ) == '0' ) index++ ;
            if ( startIndex < index && index < len && buffer.charAt( index ) == ' ' ) {
                startIndex = --index ;
            }
            else startIndex = index ;
            while ( index < len && buffer.charAt( index ) != ' ' ) index++ ;
            if ( startIndex < index ) count.add( buffer.substring(startIndex, index) ) ;
        }
        return count.size() ;
    }
}