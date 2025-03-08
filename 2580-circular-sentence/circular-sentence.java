class Solution {
    public boolean isCircularSentence(String sentence) {
        boolean isCircular = !sentence.isEmpty() && sentence.charAt(0) != ' ' && sentence.charAt(0) == sentence.charAt(sentence.length()-1) ;
        for ( int i = 0 , j , k ; isCircular && i < sentence.length() ; i++ ) {
            j = i ;
            while ( j < sentence.length() && sentence.charAt(j) != ' ' ) j++ ;
            if ( j == sentence.length() ) break;
            j-- ;
            k = j+1 ;
            while ( k < sentence.length() && sentence.charAt(k) == ' ' ) k++ ;
            isCircular = (k != sentence.length() && sentence.charAt( j ) == sentence.charAt( k )) ;
            i = k-1 ;
        }
        return isCircular ;
    }
}