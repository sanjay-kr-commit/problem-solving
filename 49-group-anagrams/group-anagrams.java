import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList <List<String>> rest = new ArrayList<>() ;
        HashSet <Integer> used = new HashSet<>() ;
        for ( int i = 0 , len = strs.length ; i < len ; i++ ) {
            String str = strs[i] ;
            if ( used.contains(i) ) continue ;
            else used.add(i) ;
            ArrayList <String> subList = new ArrayList<>() ;
            subList.add( str ) ;
            int [] freqStr = new int [ 26 ] ;
            for ( int j = 0 , jlen = str.length() ; j < jlen ; j++ ) {
                freqStr[str.charAt(j)-'a']++ ;
            }
            for ( int j = 0 ; j < len ; j++ ) {
                if ( used.contains(j) ) continue ;
                int [] subFreqStr = new int [26] ;
                for ( int k = 0 , klen = strs[j].length() ; k < klen ; k++ ) {
                    subFreqStr[ strs[j].charAt(k)-'a' ]++ ;
                }
                int k = 0 ;
                for (; k < 26 ; k++ ) {
                    if ( subFreqStr[k] != freqStr[k] ) break ;
                }
                if ( k < 26 ) continue ;
                subList.add( strs[j] ) ;
                used.add(j) ;
            }
            rest.add(subList) ;
        }
        return rest ;
    }
}