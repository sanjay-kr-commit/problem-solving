class Solution {
    public boolean checkValidString(String s) {
        int bal = 0 , star = 0;
        for( int j = 0 ; j < s.length() ; j++ ) {
            char i = s.charAt(j);
            if( i == '(' ) bal++;
            else if( i == ')' ) bal--;
            else star++;
            if ( bal < 0 && star > 0 ) {
                bal++;
                star--;
            }
            if( bal < 0 ) return false;
        }
   
        bal = 0 ;
        star = 0 ;
   
        for( int j = s.length()-1 ; j >= 0 ; j-- ){
            char i = s.charAt(j) ;
            if( i == ')' ) bal++;
            else if( i == '(' ) bal-- ;
            else star++ ;
            if ( bal < 0 && star > 0 ) {
                bal++;
                star--;
            }
            if(bal<0) return false;
        }
        return true;
    }
}