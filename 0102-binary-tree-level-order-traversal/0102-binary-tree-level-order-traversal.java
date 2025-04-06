class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        levelOrder(root , result , 0);
        return result;
    }
    
    void levelOrder( TreeNode node , ArrayList<List<Integer>> result , int level ) {
        if ( node == null ) return;
        if ( result.size() <= level ) result.add(new ArrayList<>() );
        levelOrder( node.left , result, level+1) ;
        levelOrder( node.right , result, level+1) ;
        result.get(level).add( node.val ) ;
    }
    
}
