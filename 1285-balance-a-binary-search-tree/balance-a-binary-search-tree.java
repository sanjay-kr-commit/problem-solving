class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> heap = new ArrayList<>() ;
        treeToHeap( root , heap );
        return balancedTree( 0 , heap.size()-1 , heap ) ;
    }

    void treeToHeap(TreeNode node , ArrayList<Integer> heap ) {
        if ( node == null ) return;
        treeToHeap( node.left , heap );
        heap.add( node.val ) ;
        treeToHeap( node.right , heap );
    }

    TreeNode balancedTree( int start , int end , ArrayList<Integer> heap ) {
        if ( start > end ) return null ;
        int mid = start + (end-start)/2 ;
        TreeNode node = new TreeNode() ;
        node.val = heap.get( mid ) ;
        node.left = balancedTree( start , mid -1 , heap);
        node.right = balancedTree( mid+1 , end , heap ) ; 
        return node ;
    }

}