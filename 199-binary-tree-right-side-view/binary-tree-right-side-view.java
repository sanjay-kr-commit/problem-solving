class Solution {
  
  public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>() ;
    addRightView( root , new HashSet<Integer>() , res , 0 ) ;
    return res ;
  }

  void addRightView( TreeNode node , HashSet<Integer> levelOccupied , ArrayList<Integer> res , int level ) {
    if ( node == null ) return ;
    if ( !levelOccupied.contains( level ) ) {
      levelOccupied.add( level ) ;
      res.add( node.val ) ;
    }
    addRightView( node.right , levelOccupied , res , level+1 ) ;
    addRightView( node.left , levelOccupied , res , level+1 ) ;
  }

}
