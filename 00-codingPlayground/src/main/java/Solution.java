class Solution {
    public String predictPartyVictory(String senate) {
        int stackSize = 0 , queuePtr = 0 , len = senate.length() ;
        char [] stack = new char[ len ] ;
        while ( queuePtr < len ) {
            if ( stackSize > 0 && stack[stackSize-1] != senate.charAt(queuePtr) ) stackSize-- ;
            stack[stackSize++] = senate.charAt(queuePtr++) ;
            if ( stackSize == 0 || queuePtr >= len ) continue;
            if ( stack[stackSize-1] != senate.charAt(queuePtr) ) queuePtr++ ;
        }
        return ( stackSize < 1 ) ? "" : ( stack[0] == 'R' ) ? "Radiant" : "Dire" ;
    }
}