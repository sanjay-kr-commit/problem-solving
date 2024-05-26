class Solution {
    public String interpret(String command) {
        StringBuilder interpretedString = new StringBuilder();
        int count = 0 ;
        for ( char c : command.toCharArray() ) {
            switch (c) {
                case 'G' : interpretedString.append('G'); break;
                case ')' : {
                    if ( count == 1 ) interpretedString.append( 'o' ) ;
                    else interpretedString.append( "al" ) ;
                    count = 0 ;
                } break;
                default: count++ ;
            }
        }
        return interpretedString.toString() ;
    }
}