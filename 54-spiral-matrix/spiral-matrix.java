import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int vLen = matrix.length , hLen = matrix[0].length;
        int vLim = vLen/2 , hLim = hLen/2 ,
            v = 0 , h = 0 ;
        vLim += vLen % 2 ;
        hLim += hLen % 2 ;
        List<Integer> ans = new ArrayList<>( vLen * hLen );
        while ( v < vLim && h < hLim ) {
            ans.add( matrix[v][h] );
            int i = v , j = h+1 ;
            while ( j < (hLen-h) ) {
                ans.add( matrix[i][j++] ) ;
            }
            j-- ;
            i++ ;
            while ( i < (vLen-v) ) {
                ans.add( matrix[i++][j] ) ;
            }
            i-- ;
            j-- ;
            while ( j >= h ) {
                ans.add( matrix[i][j--] ) ;
            }
            j++ ;
            i-- ;
            while ( i > v ) {
                ans.add( matrix[i--][j] ) ;
            }
            v++ ;
            h++ ;
        }
        while ( ans.size() > vLen * hLen ) ans.remove(ans.size()-1);
        return ans ;
    }
}