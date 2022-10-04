// 2ms
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0 , i = a.length() -1  ,j = b.length() - 1 ;       
        StringBuilder sum = new StringBuilder();
        while ( i > -1 && j > -1 ) {
            int local_sum = ( a.charAt(i--) + b.charAt(j--) + carry ) - ('0'*2) ;
            sum.append( local_sum % 2 ) ;
            carry = local_sum / 2 ;
        } 
        while ( i > -1 ) {
            int local_sum = a.charAt(i--) + carry - '0' ;
            sum.append( local_sum % 2 ) ;
            carry = local_sum / 2 ;
        }
        while ( j > -1 ) {
            int local_sum = b.charAt(j--) + carry - '0' ;
            sum.append( local_sum % 2 ) ;
            carry = local_sum / 2 ;
        }
        if ( carry == 1 ) sum.append( carry ) ;
        return sum.reverse().toString();
    }
}