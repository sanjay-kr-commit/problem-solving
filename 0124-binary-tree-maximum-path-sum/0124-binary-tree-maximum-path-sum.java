class Solution {
    public int maxPathSum(TreeNode root) {
        if ( root == null ) return 0 ;
        int [] max = new int[1] ;
        boolean allNegative = allNegative(root) ;
        if ( allNegative ) return maxNodeVal( root ) ;
        max[0] = Integer.MIN_VALUE;
        traverse( root , max , 0 , 0 ) ;
        return max[0] ;
    }
    
    int maxNodeVal( TreeNode root ) {
        if ( root == null ) return Integer.MIN_VALUE ;
        return Math.max( root.val , Math.max( maxNodeVal( root.left ), maxNodeVal( root.right ) ) ) ;
    }

    boolean allNegative(TreeNode root) {
        return root == null || ( root.val < 0 && allNegative(root.left) && allNegative(root.right) );
    }

    int traverse( TreeNode root, int [] max, int sum , int level ) {
        if ( root == null ) return 0 ;
        sum = Math.max( 0 , Math.max(sum + root.val, root.val)) ;
        int left = traverse( root.left , max , sum , level + 1 ) ,
            right = traverse( root.right , max , sum , level + 1 ) ;
        max[0] = Math.max( max[0] , root.val ) ;
        max[0] = Math.max( max[0] , sum ) ;
        max[0] = Math.max( max[0] , left+sum ) ;
        max[0] = Math.max( max[0] , right+sum ) ;
        max[0] = Math.max( max[0] , right+left+root.val ) ;
        return Math.max( 0 , Math.max( root.val , root.val + Math.max( left , right )) ) ;
    }
}