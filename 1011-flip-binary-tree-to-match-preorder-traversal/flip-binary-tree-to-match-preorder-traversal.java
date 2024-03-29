class Solution {

    ArrayList<Integer> swappedNodes ;
    int i = 0 ;
    int[] voyage ;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        i = 0 ;
        this.voyage = voyage ;
        swappedNodes = new ArrayList<>() ;
        return ( dfs( root ) ) ? swappedNodes : List.of(-1);
    }

    boolean dfs( TreeNode node ) {
        if ( node == null ) return true ;
        if ( node.val != voyage[i++] ) return false ;
        if ( node.left != null && node.left.val != voyage[i] ) {
            swappedNodes.add( node.val ) ;
            return dfs( node.right ) && dfs( node.left ) ;
        }
        return dfs( node.left ) && dfs( node.right ) ;
    }
    
}