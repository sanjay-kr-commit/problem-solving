// fastest solution

// using substring method to check
class Solution4 
{
    public boolean repeatedSubstringPattern(String s) 
    {
        //String part="";
        for(int i=1;i<=s.length()/2;i++)
        {
            if(s.length()%i==0)//check if equal parts can be formed
            {
                String part=s.substring(0,i);
                int j=i;
                while(j<s.length() && s.substring(j,j+i).equals(part))
                  j+=i;
                if(j==s.length())
                  return true;
            }
        }
        return false;
    }
}

// without using substring method

class Solution3 {
    public boolean repeatedSubstringPattern(String s) {
        int i = 1 , len = s.length() , poss = len / 2 ;
        while ( i <= poss ) {
            while ( i < poss && s.charAt( 0 ) != s.charAt( i ) ) i++ ;
            if ( s.length()%i == 0 ) {
                for ( int j = 0 ; j <= s.length()-i ; j++ ) {
                    if ( j == len-i ) return true ;
                    if ( s.charAt( j ) != s.charAt( i+j ) ) break;
                }
            }
            i++ ;
        }
        return false ;
    }

}

// super slow

class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        int g = 1 , len = s.length() ;
        while ( g < len ) {
            while ( g < len && s.charAt( 0 ) != s.charAt( g ) ) g++ ;
            if ( g >= len ) break;
            if ( check( g , s ) ) return true ;
            g++ ;
        }
        return false ;
    }

    public boolean check( int g , String s ) {
        int len = s.length() ;
        int i = 0 ;
        int counter = 0 ;
        while ( i < len-g ) {
            if ( s.charAt( i ) != s.charAt( i+g ) ) return false ;
            i++ ;
            counter = (counter == g-1 )?0:counter+1;
        }
        return counter == 0 ;
    }

}

// slowest
class Solution1 {
    public boolean repeatedSubstringPattern(String s) {

     int n = s.length();
     for(int j=0; j<n/2; j++){
       String pattern = s.substring(0, j+1);
       if(isMatch(s, pattern)) return true;
     }

     return false;   
    }
    public boolean isMatch(String s, String pattern){
      
      int i=0;
      int size = pattern.length();
      int n = s.length();

      while(i<n-size+1){
        String temp = s.substring(i, i+size);
        if(!temp.equals(pattern)) return false;
        i = (i+size);
      }
      return n == i ? true : false;
    }
}
