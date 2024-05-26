class Solution {
    public String interpret(String command) {
        StringBuilder interpretedString = new StringBuilder();
        int count = 0 ;
        for ( int i = 0 ; i < command.length() ; i++ ) {
            switch ( command.charAt(i) ) {
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