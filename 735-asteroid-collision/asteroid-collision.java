class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>() ;
        for ( int i : asteroids ) {
            boolean isNegative = i < 0 ;
            int val = i * ((isNegative) ? -1 : 1) ;
            if (!isNegative || st.isEmpty() || st.peek() < 0) st.push( i ) ;
            else {
                while ( !st.isEmpty() && st.peek() > 0 && st.peek() < val ) st.pop() ;
                if ( !st.isEmpty() && st.peek() == val ) st.pop() ;
                else if ( st.isEmpty() || st.peek() < 0 || st.peek() < val ) st.push( i ) ;
            }
        }
        int [] arr = new int[ st.size() ] ;
        for ( int i = 0 ; !st.isEmpty() ; i++ ) arr[i] = st.pop() ;
        for ( int left = 0 ; left < arr.length/2 ; left++ ) {
            int right = arr.length-left-1;
            arr[left] += arr[right] ;
            arr[right] = arr[left] - arr[right] ;
            arr[left] -= arr[right] ;
        }
        return arr ;
    }
}