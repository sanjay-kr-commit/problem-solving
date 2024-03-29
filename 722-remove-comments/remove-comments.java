class Solution {
    public List<String> removeComments(String[] source) {
        ArrayList<String> uncommentedSource = new ArrayList<>( source.length ) ;

       boolean blockComment = false ;
        StringBuilder uncommentedLine = new StringBuilder() ;
        for ( String sourceLine : source ) {

            boolean lineComment = false;
            int i = 0 ;

            for ( ; i < sourceLine.length()-1 ; i ++ ) {

                char token = sourceLine.charAt( i ) ;
                char commentModifier = sourceLine.charAt( i+1 ) ;

                if ( token == '/' && commentModifier == '/' && !blockComment ) {
                    lineComment = true ;
                    break;
                }
                else if ( token == '/' && commentModifier == '*' && !blockComment ){
                    blockComment = true ;
                    i++ ;
                }
                else if ( token == '*' && commentModifier == '/' && blockComment ) {
                    blockComment = false ;
                    i++ ;
                } else if ( !blockComment ) uncommentedLine.append( token ) ;

            }

            if ( !lineComment && !blockComment && i < sourceLine.length() ) uncommentedLine.append( sourceLine.charAt( i ) ) ;

            if ( !uncommentedLine.isEmpty() && !blockComment ){
                uncommentedSource.add( uncommentedLine.toString() ) ;
                uncommentedLine = new StringBuilder() ;
            }

        }

        return uncommentedSource ;
    }
}