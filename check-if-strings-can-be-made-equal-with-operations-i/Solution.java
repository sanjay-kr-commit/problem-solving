class Solution {
    public boolean canBeEqual(String s1, String s2) {
        boolean canBeEqual = true ;
        char[] a1 = s1.toCharArray() ,
               a2 = s2.toCharArray() ;
        for ( int i = 0 , len = a1.length-2 ; i < len && canBeEqual ; i++ ) if ( a1[i] != a2[i] ) {
            canBeEqual = a1[i] == a2[i+2] && a1[i+2] == a2[i] ;
            char temp = a2[i] ;
            a2[i] = a2[i+2] ;
            a2[i+2] = temp ;
        }
        for ( int i = a1.length-2 ; i < a1.length && canBeEqual ; i++ ) canBeEqual = a1[i] == a2[i] ;
        return canBeEqual ;
    }
}
