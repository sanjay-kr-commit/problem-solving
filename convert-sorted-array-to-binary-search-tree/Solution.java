// took 1 ms
class Solution1 {

    TreeNode bst = null ;
    
    private void add( int x ) {
        if ( bst == null ) bst = new TreeNode( x ) ;
        else {
            TreeNode node = bst ;
            while ( true ) {
                if ( node.val == x ) return ;
                else if ( node.val > x ) {
                    if ( node.left == null ) {
                        node.left = new TreeNode( x ) ;
                        return ;
                    } else node = node.left ;
                } else {
                    if ( node.right == null ) {
                        node.right = new TreeNode( x );
                        return ;
                    } else node = node.right ;    
                }
            }
        }
    }

    public void helper( int[] nums , int low , int hi ) {
        int mid = low + ( hi - low ) / 2 ;
        if ( mid > -1 && mid < nums.length ) add( nums[mid] );
        if ( hi - mid > 0 ) helper(nums, mid+1 , hi);
        if ( mid - low > 0 ) helper(nums, low, mid);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        helper(nums, 0, nums.length-1);
        return bst ;
    }
}

// took 0 ms
class Solution {
    
    public TreeNode sortedArrayToBST( int[] nums ) {
        return helper( nums , 0 , nums.length-1 ) ;
    }

    public TreeNode helper( int[] nums , int lo , int hi ) {
        if ( lo > hi ) return null ;
        int mid = lo + ( hi - lo) /2;
        TreeNode root = new TreeNode( nums[mid] ) ;
        root.left = helper( nums , lo, mid-1) ;
        root.right = helper(nums , mid+1, hi) ;
        return root ; 
    }

}