class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if ( rows == 1 || encodedText.isEmpty()) return encodedText ;
        StringBuilder decodedString = new StringBuilder() ;
        int n = encodedText.length() , cols = n / rows , colPointer = 0 , rowPointer = 0 ;
        while ( rowPointer < cols ) {
            decodedString.append( encodedText.charAt(colPointer) ) ;
            colPointer += cols + 1 ;
            if ( colPointer >= n ) {
                rowPointer++ ;
                colPointer = rowPointer ;
            }
        }
        int spaces = decodedString.length()-1 ;
        while ( spaces > 0 && decodedString.charAt(spaces) == ' ' ) spaces-- ;
        return decodedString.substring( 0 , spaces+1 ) ;
    }
}