class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int [] traversedArray = new int [ mat.length * mat[0].length ] ;
        traverse( traversedArray , mat , 0 , 0 , mat.length , mat[0].length , 0 , true );
        return traversedArray ;
    }

    void traverse(int[] traversalArray, int [][] mat , int i , int j , int len , int breath , int index , boolean up ) {
        traversalArray[index] = mat[i][j] ;
        if ( i == len-1 && j == breath-1 ) return;
        int ii = ( up ) ? i-1 : i+1 ;
        int jj = ( up ) ? j+1 : j-1 ;
        boolean newUp = up ;
        if ( ii == len ) {
            ii-- ;
            jj += 2 ;
            newUp = !up ;
        } else if ( jj == breath ) {
            jj-- ;
            ii += 2 ;
            newUp = !up ;
        } else if ( ii < 0 ) {
            ii = 0 ;
            newUp = !up ;
        } else if ( jj < 0 ) {
            jj = 0 ;
            newUp = !up ;
        }
        traverse( traversalArray , mat , ii , jj , len , breath , index+1 , newUp );
    }

}