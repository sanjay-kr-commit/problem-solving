class Solution {

    private final ArrayList<Integer> impossible ;

    public Solution() {
        impossible = new ArrayList<>() ;
        impossible.add( -1 ) ;
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if ( (root == null && voyage.length != 0) || (voyage.length > 0 && root.val != voyage[0]) ) return impossible ;
        return helper( root , voyage , new ArrayList<>() , 0 ) ;
    }

    List<Integer> helper( TreeNode node , int [] voyage , ArrayList<Integer> ans , int depth ) {
        if ( node == null || ( node.left == null && node.right == null )) return ans ;
        int lPos = depth * 2 + 1 , rPos = lPos + 1 ;
        if ( helper( node.left , voyage , ans , lPos ) == impossible || helper( node.right , voyage , ans , rPos ) == impossible ) return impossible ;
        Integer leftVoy = ( voyage.length <= lPos ) ? null : voyage[lPos] , rightVoy = ( voyage.length <= rPos ) ? null : voyage[rPos] ,
                leftNod = ( node.left == null ) ? null : node.left.val , rightNod = ( node.right == null ) ? null : node.right.val ;
        if ( Objects.equals( leftVoy , rightNod ) && Objects.equals( rightVoy , leftNod ) ) {
            TreeNode temp = node.right ;
            node.right = node.left ;
            node.left = temp ;
            ans.add( node.val ) ;
        } else if ( !Objects.equals( leftVoy , leftNod ) || !Objects.equals( rightVoy , rightNod ) ) return impossible ;
        return ans ;
    }

}
