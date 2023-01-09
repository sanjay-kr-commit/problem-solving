class Solution {
    public String addStrings(String num1, String num2) {
      StringBuilder st = new StringBuilder() ;
      int i = num1.length() , j = num2.length() , rem = 0 ;
      while ( i > 0 && j > 0 ) {
        int sum = (num1.charAt( --i )-'0') + ( num2.charAt( --j ) - '0' ) + rem ;
        rem = sum / 10 ;
        st.append( sum % 10 ) ;
      }
      while ( i > 0 ) {
        int sum = (num1.charAt( --i )-'0') + rem ;
        rem = sum / 10 ;
        st.append( sum % 10 ) ;
      }
      while ( j > 0 ) {
        int sum = (num2.charAt( --j )-'0') + rem ;
        rem = sum / 10 ;
        st.append( sum % 10 ) ;
      }
      while ( rem != 0 ) {
        st.append( rem % 10 ) ;
        rem /= 10 ;
      }
      return st.reverse().toString() ;
    }
}
