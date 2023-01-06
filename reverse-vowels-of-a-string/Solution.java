import java.util.HashSet;

class Solution1 {
    public String reverseVowels(String s) {
      StringBuilder vowels = new StringBuilder() ;
      StringBuilder constant = new StringBuilder() ;
      for ( int i = 0 ; i < s.length() ; i++ ) {
        char t = s.charAt( i ) ;
        switch ( t ) {
          case 'a' : case 'e' : case 'i' : case 'o' : case 'u' :
          case 'A' : case 'E' : case 'I' : case 'O' : case 'U' :
            vowels.append( t ) ;
            constant.append( 'a' ) ;
            break;
          default:
            constant.append( t ) ;
            break;
        }
      }
      int j = vowels.length()-1 ;
      StringBuilder NewString = new StringBuilder() ;
      for ( int i = 0 ; i < constant.length() ; i++ ) {
        char t = constant.charAt( i ) ;
        if ( t != 'a' ) {
          NewString.append( t );
        } else NewString.append( vowels.charAt( j-- ) ) ;
      }
      return NewString.toString() ;
    }
}

class Solution {

    HashSet<Character> VOWELS = new HashSet<>(
            List.of(
                    'a' , 'e' , 'i' , 'o' , 'u' ,
                    'A' , 'E' , 'I' , 'O' , 'U'
            )
    ) ;

    public String reverseVowels(String s) {
        StringBuilder ss = new StringBuilder( s ) ;
        int i = 0 , j = ss.length()-1 ;
        while ( i < j ) {
            while ( i < j && !VOWELS.contains( ss.charAt( i ) ) ) i++ ;
            while ( i < j && !VOWELS.contains( ss.charAt( j ) ) ) j-- ;
            if ( i < j ) {
                char temp = ss.charAt( i ) ;
                ss.setCharAt( i , ss.charAt( j ) );
                ss.setCharAt( j , temp );
                i++ ; j-- ;
            }
        }
        return ss.toString() ;
    }
}
