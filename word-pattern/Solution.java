// 2ms
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split( " " ) ;
        if ( words.length != pattern.length() ) return  false ;
        HashMap<Character,String> wordMap = new HashMap<>() ;
        HashSet<String> wordCheck = new HashSet<>() ;
        for ( int i = 0 ; i < pattern.length() ; i++ ) {
            String word = words[i] ;
            char ch = pattern.charAt( i ) ;
            if ( wordMap.containsKey( ch ) ) {
                if ( !wordMap.get( ch ).equals( word ) ) return  false ;
            } else if ( wordCheck.contains( word ) ) return  false ; 
            else {
                wordCheck.add( word ) ;
                wordMap.put( ch , word ) ;
            }
        }
        return true ;
    }
}