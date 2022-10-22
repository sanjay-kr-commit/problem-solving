import java.util.HashMap;
import java.util.Map;

// 70 ms
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        if ( s.length() != t.length() ) return false ;
        Map<Character,Character> hm1 = new HashMap<>() ;
        Map<Character,Character> hm2 = new HashMap<>() ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char j = s.charAt(i) , k = t.charAt(i) ;
            if ( hm1.containsKey(j) && hm1.get(j) != k ) return false ;
            else hm1.put(j, k) ;
            if ( hm2.containsKey(k) && hm2.get(k) != j ) return false ;
            else hm2.put(k, j) ;
            
        }
        return true ;
    }
}

// 11 ms
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        if ( s.length() != t.length() ) return false ;
        char[] ss = new char[128] ;
        char[] tt = new char[128] ;
        char none = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char j = s.charAt(i) , k = t.charAt(i) ;
            if ( ss[j] == none ) ss[j] = k ;
            if ( tt[k] == none ) tt[k] = j ;
            if ( tt[k] != j || ss[j] != k ) return false ;

        }
        return true ;        
    }
}

// 8ms
class Solution3 {
    public boolean isIsomorphic( String s , String t ) {
       // if length not equal than its already impossible
        if ( s.length() != t.length() ) return false ;
        // string to array
        char[] ss = s.toCharArray() ;
        char[] tt = t.toCharArray() ;
        // for mapping character
        char[] ch = new char[128] ;
        // to check whether the character has been mapped or not
        boolean [] s1 = new boolean[128] ;
        boolean [] t1 = new boolean[128] ;
        // loop
        for ( int i = 0 ; i < s.length() ; i++ ) {
            // check if the character has been mapped or not
            if ( s1[ss[i]] == false ) {
                // map the t charcter with s character in ch array
                ch[ss[i]] = tt[i] ;
                // mark the charaction mapping to true so we don't map everything repeatedly
                s1[ss[i]] = true ;
                // checking if the other character has been mapped or not
                if ( t1[tt[i]] == true ) return false ;
                // mark the character map to true
                t1[tt[i]] = true ;
            } else {
                // the character has been mapped but the character mismatches between string
                if ( ch[ss[i]] != tt[i] ) return false ;
            }
        }
        return true ;
    }
}

// 22 ms
class Solution4 {
    public boolean isIsomorphic( String s , String t ) {
       if ( s.length() != t.length() ) return false ;
        char[] ch = new char[128] ;
        boolean [] s1 = new boolean[128] ;
        boolean [] t1 = new boolean[128] ;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( s1[s.charAt(i)] == false ) {
                ch[s.charAt(i)] = t.charAt(i) ;
                s1[s.charAt(i)] = true ;
                if ( t1[t.charAt(i)] == true ) return false ;
                t1[t.charAt(i)] = true ;
            } else {
                if ( ch[s.charAt(i)] != t.charAt(i) ) return false ;
            }
        }
        return true ;
    }
}